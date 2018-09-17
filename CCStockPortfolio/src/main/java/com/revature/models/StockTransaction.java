package com.revature.models;


import javax.persistence.*;
import java.sql.Date;

public class StockTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionSequence")
	@SequenceGenerator(name="beehiveSequence", allocationSize=1, sequenceName = "SQ_TRANSACTION_PK")
	private int id;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "STOCK_SYMBOL")
	private String stockSymbol;
	
	@Column(name = "STOCK_NAME")
	private String stockName;
	
	@Column(name = "OPEN_PRICE")
	private float openPrice;
	
	@Column(name = "CURRENT_PRICE")
	private float currentPrice;
	
	@Column(name = "NUM_SHARES")
	private  int numShares;
	
	@Column(name = "BOUGHT_FOR")
	private float boughtFor;
	
	@Column(name = "SELLING_FOR")
	private float sellingFor;
	
	@Column(name = "TOTAL_RETURN")
	private float totalReturn;
	
	@Column(name = "DATE")
	private Date date;

	public StockTransaction() {
		super();
	}

	public StockTransaction(int id, int userId, String stockSymbol, String stockName, float openPrice, float currentPrice,
			int numShares, float boughtFor, float sellingFor, float totalReturn, Date date) {
		super();
		this.id = id;
		this.userId = userId;
		this.stockSymbol = stockSymbol;
		this.stockName = stockName;
		this.openPrice = openPrice;
		this.currentPrice = currentPrice;
		this.numShares = numShares;
		this.boughtFor = boughtFor;
		this.sellingFor = sellingFor;
		this.totalReturn = totalReturn;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public float getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(float openPrice) {
		this.openPrice = openPrice;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getNumShares() {
		return numShares;
	}

	public void setNumShares(int numShares) {
		this.numShares = numShares;
	}

	public float getBoughtFor() {
		return boughtFor;
	}

	public void setBoughtFor(float boughtFor) {
		this.boughtFor = boughtFor;
	}

	public float getSellingFor() {
		return sellingFor;
	}

	public void setSellingFor(float sellingFor) {
		this.sellingFor = sellingFor;
	}

	public float getTotalReturn() {
		return totalReturn;
	}

	public void setTotalReturn(float totalReturn) {
		this.totalReturn = totalReturn;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(boughtFor);
		result = prime * result + Float.floatToIntBits(currentPrice);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + numShares;
		result = prime * result + Float.floatToIntBits(openPrice);
		result = prime * result + Float.floatToIntBits(sellingFor);
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result + Float.floatToIntBits(totalReturn);
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockTransaction other = (StockTransaction) obj;
		if (Float.floatToIntBits(boughtFor) != Float.floatToIntBits(other.boughtFor))
			return false;
		if (Float.floatToIntBits(currentPrice) != Float.floatToIntBits(other.currentPrice))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (numShares != other.numShares)
			return false;
		if (Float.floatToIntBits(openPrice) != Float.floatToIntBits(other.openPrice))
			return false;
		if (Float.floatToIntBits(sellingFor) != Float.floatToIntBits(other.sellingFor))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		if (Float.floatToIntBits(totalReturn) != Float.floatToIntBits(other.totalReturn))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", stockSymbol=" + stockSymbol + ", stockName="
				+ stockName + ", openPrice=" + openPrice + ", currentPrice=" + currentPrice + ", numShares=" + numShares
				+ ", boughtFor=" + boughtFor + ", sellingFor=" + sellingFor + ", totalReturn=" + totalReturn + ", date="
				+ date + "]";
	}

	
}
