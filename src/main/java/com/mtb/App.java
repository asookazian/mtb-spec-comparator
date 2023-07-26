package com.mtb;

import java.io.File;

/**
 * Main app for mtb geo specs calculator
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	App app = new App();
    	app.execute();
    }
    
    private void execute() {
    	
    	File file = new File("classes/mtb-specs.csv");
    	String absPath = file.getAbsolutePath();
    	boolean fileExists = file.exists();
    	System.out.println("fileExists = " + fileExists);
    	System.out.println("absPath = " + absPath);
        MtbSpecsCsvToBean.processCsv();
    }
}
