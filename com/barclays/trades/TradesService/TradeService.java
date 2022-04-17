package com.barclays.trades.TradesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TradeService 
{
	List<Trades> tradeList = new ArrayList<Trades>();
	
	TradeService()
	{
		populateTradeList();
	}
	
	void populateTradeList()
	{
		this.tradeList.add(new Trades("T1", 1, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), "N"));
		this.tradeList.add(new Trades("T2", 2, "CP-2", "B1", LocalDate.of(2020, 05, 20), LocalDate.now(), "N"));
		this.tradeList.add(new Trades("T2", 1, "CP-1", "B1", LocalDate.of(2020, 05, 20), LocalDate.of(2015, 03, 14), "N"));
		this.tradeList.add(new Trades("T3", 3, "CP-3", "B2", LocalDate.of(2020, 05, 20), LocalDate.now(), "Y"));
		//printDetails();
		updateExpiredFlag();
		//printDetails();
	}
	
	public void updateExpiredFlag()
	{
		tradeList.stream().filter(t -> LocalDate.now().isAfter(t.getMaturityDate())).forEach(t -> t.setExpired("Y"));
	}
	
	public String addTradeInList(Trades trade) throws Exception
	{
		LocalDate date = LocalDate.now();
		return trade.getMaturityDate().isBefore(date) ? "Maturity date is less than Current date" : saveTrade(trade);
	}
	
	public String saveTrade(Trades trade) throws Exception
	{
		tradeList.stream().filter(t -> isValidTrade(t, trade)).
				sorted((t1, t2) -> t2.getVersion().compareTo(t1.getVersion())).forEach(t -> updateDetails(t, trade));
		return "Success";
	}
	
	public void printDetails()
	{
		tradeList.stream().forEach(System.out :: println);
	}
	
	public boolean isValidTrade(Trades oldTrade, Trades newTrade)
	{
		return oldTrade.getTradeId().equals(newTrade.getTradeId()) && oldTrade.getCounterPartyID().equals(newTrade.getCounterPartyID()) && 
				oldTrade.getBookID().equals(newTrade.getBookID());
	}
	
	public void updateDetails(Trades t, Trades trade)
	{
		if(t.getVersion() > trade.getVersion())
		{
			System.out.println("t.getVersion() > trade.getVersion() :: "+ t.getVersion() +" > " +trade.getVersion());
			throw new RuntimeException("Lower trade version received");
		}
		else if(t.getVersion() == trade.getVersion())
		{
			t.setMaturityDate(trade.getMaturityDate());
			t.setCreatedDate(trade.getCreatedDate());
			t.setExpired("N");
			System.out.println("Update trade is :: "+ t);
		}
	}
}
