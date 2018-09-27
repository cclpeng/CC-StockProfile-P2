package com.revature.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="STOCK_TRANSACTIONS")
@Component
public class StockTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="transactionSequence")
	@SequenceGenerator(name="transactionSequence", allocationSize =1, sequenceName = "SQ_TRANSACTION_PK")
	@Column(name = "STOCK_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@Column(name = "STOCK_SYMBOL")
	private String stockSymbol;
	
	@Column(name = "STOCK_NAME")
	private String stockName;
	
	@Column(name = "NUM_SHARES")
	private int numShares;
	
//	@Column(name = "OPEN_PRICE")
//	private float openPrice;
	
//	@Column(name = "CURRENT_PRICE")  //these we grab from the api when we need
//	private float currentPrice;
	
	@Column(name = "BOUGHT_FOR")   //bought at the time
	private float boughtFor;
	
	@Column(name = "SELLING_FOR")  //sold for (NOT THE CURRENT PRICE) ...null until it's sold?
	private float sellingFor;
	
//	@Column(name = "TOTAL_RETURN")
//	private BigDecimal totalReturn;
	
	@Column(name = "TRANSACTION_DATE")
	private Date date;
	
	@Column(name = "STATUS") //"sold" or "unsold"
	private String status;

	public StockTransaction() {
		super();
	}

	public StockTransaction(User user, String stockSymbol, String stockName, int numShares,
			float boughtFor, float sellingFor, Date date, String status) {
		super();
		this.user = user;
		this.stockSymbol = stockSymbol;
		this.stockName = stockName;
		this.numShares = numShares;
//		this.openPrice = openPrice;
//		this.currentPrice = currentPrice;
		this.boughtFor = boughtFor;
		this.sellingFor = sellingFor;
//		this.totalReturn = totalReturn;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public int getNumShares() {
		return numShares;
	}

	public void setNumShares(int numShares) {
		this.numShares = numShares;
	}

//	public float getOpenPrice() {
//		return openPrice;
//	}
//
//	public void setOpenPrice(float openPrice) {
//		this.openPrice = openPrice;
//	}

//	public float getCurrentPrice() {
//		return currentPrice;
//	}
//
//	public void setCurrentPrice(float currentPrice) {
//		this.currentPrice = currentPrice;
//	}

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

//	public BigDecimal getTotalReturn() {
//		return totalReturn;
//	}
//
//	public void setTotalReturn(BigDecimal totalReturn) {
//		this.totalReturn = totalReturn;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "StockTransaction [id=" + id + ", user=" + user + ", stockSymbol=" + stockSymbol + ", stockName="
				+ stockName + ", numShares=" + numShares + ", boughtFor=" + boughtFor + ", sellingFor=" + sellingFor
				+ ", date=" + date + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(boughtFor);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numShares;
		result = prime * result + Float.floatToIntBits(sellingFor);
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numShares != other.numShares)
			return false;
		if (Float.floatToIntBits(sellingFor) != Float.floatToIntBits(other.sellingFor))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
}
