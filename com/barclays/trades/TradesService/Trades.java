package com.barclays.trades.TradesService;

import java.time.LocalDate;

public class Trades 
{
	private String tradeId;
	private Integer version;
	private String counterPartyID;
	private String bookID;
	private LocalDate maturityDate;
	private LocalDate createdDate;
	private String expired;
	
	public Trades(String tradeId, Integer version, String counterPartyID, String bookID, LocalDate maturityDate, LocalDate createdDate,
			String expired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyID = counterPartyID;
		this.bookID = bookID;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}

	public String getTradeId() {
		return tradeId;
	}

	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCounterPartyID() {
		return counterPartyID;
	}

	public void setCounterPartyID(String counterPartyID) {
		this.counterPartyID = counterPartyID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	@Override
	public String toString() {
		return "Trades [tradeId=" + tradeId + ", version=" + version + ", counterPartyID=" + counterPartyID
				+ ", bookID=" + bookID + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", expired=" + expired + "]";
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getExpired() {
		return expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	
	

}
