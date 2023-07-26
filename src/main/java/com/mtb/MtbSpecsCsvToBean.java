package com.mtb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class MtbSpecsCsvToBean {
	
	public static void processCsv() {
		
		String p = walkPath(".", "mtb-specs.csv");
		System.out.println("p from walkPath = " + p);
		
		//model, size, STL, TTL, R, S, CSL, HTL, HTA, STAE, BBH, WB, SOH, BBO

		Map<String, String> mapping = new HashMap<>();
		mapping.put("model", "bikeName");
		mapping.put("size", "bikeSize");
		mapping.put("STL", "seatTubeLength");
		mapping.put("TTL", "topTubeLength");
		mapping.put("R", "reach");		
		mapping.put("S", "stack");
		mapping.put("CSL", "chainstayLength");
		mapping.put("HTL", "headTubeLength");
		mapping.put("HTA", "headTubeAngle");
		mapping.put("STAE", "seatTubeAngleEffective");		
		mapping.put("BBH", "bottomBracketHeight");
		mapping.put("WB", "wheelBase");
		mapping.put("SOH", "standOverHeight");
		mapping.put("BBO", "bottomBracketOffset");

		HeaderColumnNameTranslateMappingStrategy<MtbSpecsBean> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
		strategy.setType(MtbSpecsBean.class);
		strategy.setColumnMapping(mapping);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(p));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CsvToBean<MtbSpecsBean> csvToBean = new CsvToBean<>();
		csvToBean.setCsvReader(csvReader);
		csvToBean.setMappingStrategy(strategy);

		List<MtbSpecsBean> list = (List<MtbSpecsBean>) csvToBean.parse();

		for (MtbSpecsBean b : list) {
			System.out.println(b);
		}
		System.out.println("\n");
		
		//calculate diffs on all specs values between all bikes provided in .csv file
		int listSize = list.size();
		calculateDiffs(list);
		while(listSize > 1) {
			listSize = list.size();
			if(listSize > 1) {
				list.remove(0);
				calculateDiffs(list);
			}
		}		
	}
	
	private static void calculateDiffs(List<MtbSpecsBean> list) {
		
		int counter = 1;
		
		MtbSpecsBean a = list.get(0);
		
		while (counter < list.size()) {
			
			MtbSpecsBean b = list.get(counter);
		
			System.out.println(a.getBikeName() + " vs " + b.getBikeName() + " spec diffs following...");
			System.out.println("BBH: a vs b: " + (a.getBottomBracketHeight() - b.getBottomBracketHeight()));
			System.out.println("BBO: a vs b: " + (a.getBottomBracketOffset() - b.getBottomBracketOffset()));
			System.out.println("CSL: a vs b: " + (a.getChainstayLength() - b.getChainstayLength()));
			System.out.println("HTA: a vs b: " + (a.getHeadTubeAngle() - b.getHeadTubeAngle()));
			System.out.println("HTL: a vs b: " + (a.getHeadTubeLength() - b.getHeadTubeLength()));
			System.out.println("STAE: a vs b: " + (a.getSeatTubeAngleEffective() - b.getSeatTubeAngleEffective()));
			System.out.println("STL: a vs b: " + (a.getSeatTubeLength() - b.getSeatTubeLength()));
			System.out.println("R: a vs b: " + (a.getReach() - b.getReach()));
			System.out.println("S: a vs b: " + (a.getStack() - b.getStack()));
			System.out.println("SOH: a vs b: " + (a.getStandOverHeight() - b.getStandOverHeight()));
			System.out.println("TTL: a vs b: " + (a.getTopTubeLength() - b.getTopTubeLength()));
			System.out.println("WB: a vs b: " + (a.getWheelBase() - b.getWheelBase()));
			System.out.println("\n");
			
			counter++;
		}
	}
	
	private static String walkPath(String path, String fileToSearch) {
		
		List<String> paths = new ArrayList<>();
		
		try (Stream<Path> walkStream = Files.walk(Paths.get(path))) {
		    walkStream.filter(p -> p.toFile().isFile()).forEach(f -> {
		        if (f.toString().endsWith(fileToSearch)) {
		            System.out.println(f + " found!");
		            paths.add(f.toString());
		        }
		    });
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		for(String p : paths) {			
			if(p.startsWith(".\\target\\classes") || p.startsWith(".\\classes")) {
            	return p;
        	}
		}
		
		return "";
	}
}

