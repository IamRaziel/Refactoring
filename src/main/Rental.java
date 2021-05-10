package main;

class Rental 
{
    private Movie movie;
    private int daysRented;
    
    public Rental(Movie movie, int daysRented)
    {
        this.movie = movie;
        this.daysRented = daysRented;
    }
    
    public int getDaysRented() 
    {
        return daysRented;
    }
    
    public Movie getMovie()
    {
        return movie;
    }
    
    public double calculateAmount()
    {
    	double thisAmount = 0;
    	
        switch (movie.getPriceCode()) 
        {
            case REGULAR:
                thisAmount = daysRented;
                if (daysRented > 2)
                    thisAmount *= 1.5;
                break;
            case NEW_RELEASE:
                thisAmount = daysRented * 3;
                break;
            case CHILDRENS:
                thisAmount = 1.5;
                if (daysRented > 3)
                    thisAmount *= (daysRented - 3);
                break;
        }
        return thisAmount;
    }
    
    public int calculateRenterPoints()
    {
    	return (movie.getPriceCode() == PriceCode.NEW_RELEASE && daysRented >= 2) ? 2 : 1;
    }
    
    public String toString()
    {
    	return movie.getTitle()+ "\t" + "\t" + daysRented + "\t" + String.valueOf(calculateAmount());
    }
}