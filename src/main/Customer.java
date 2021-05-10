package main;

import java.lang.*;
import java.util.*;

class Customer 
{
	private String name;
    private List<Rental> rentals = new ArrayList<>();
    
    public Customer (String name)
    {
        this.name = name;
    }
    
    public void rentAMovie(Movie movie, int daysRented) 
    {
        rentals.add(new Rental(movie, daysRented));
    }
    
    public String getName ()
    {
        return name;
    }
    
    public String statement()
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        for (Rental each : rentals)
        {
            //determine amounts for each line
        	double thisAmount = each.calculateAmount();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
    