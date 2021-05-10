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
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental each : rentals)
        {
            //determine amounts for each line
        	totalAmount += each.calculateAmount();
            // add frequent renter points
            frequentRenterPoints += each.calculateRenterPoints();
            //show figures for this rental
            result.append("\t" + each.toString() + "\n");
        }
        //add footer lines
        result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
        result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return result.toString();
    }
}
    