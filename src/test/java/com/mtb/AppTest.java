package com.mtb;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     
    public AppTest( String testName )
    {
        super( testName );
    }*/

    /**
     * @return the suite of tests being tested
     
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }*/

    /**
     * Rigourous Test :-)
     */
	@Test
    public void testApp() {
		MtbSpecsCsvToBean.processCsv();
    }
}
