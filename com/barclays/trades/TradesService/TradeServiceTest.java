package com.barclays.trades.TradesService;

import java.time.LocalDate;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TradeServiceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TradeServiceTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TradeServiceTest.class );
    }
    
    public void testAddTradeToListWithInvalidMaturityDate() throws Exception
    {
    	TradeService t = new TradeService();
    	assertEquals("Maturity date is less than Current date", t.addTradeInList(new Trades("T3", 3, "CP-3", "B2", LocalDate.of(2020, 05, 20), LocalDate.now(), "Y")));
    }
    
    public void testAddTradeToListWithSameVersion() throws Exception
    {
    	TradeService t = new TradeService();
    	assertEquals("Success", t.addTradeInList(new Trades("T3", 3, "CP-3", "B2", LocalDate.now(), LocalDate.now(), "N")));
    }
    
    public void testAddTradeToListWithLowerVersion()
    {
    	TradeService t = new TradeService();
    	try {
    	t.addTradeInList(new Trades("T3", 2, "CP-3", "B2", LocalDate.now(), LocalDate.now(), "N"));
    	}
    	catch(Exception e)
    	{
    		assertEquals("Lower trade version received", e.getMessage());
    	}
    }
}
