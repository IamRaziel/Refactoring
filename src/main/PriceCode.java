package main;

public enum PriceCode 
{	
	REGULAR(0), NEW_RELEASE(1), CHILDRENS(2);
	
	private int priceCode;
	
	private PriceCode(int priceCode)
	{
		this.priceCode = priceCode;
	}
	
	public int getPriceCode()
	{
		return priceCode;
	}
}
