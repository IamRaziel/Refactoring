package test;

import org.junit.Assert;
import org.junit.Test;

import main.Movie;
import main.PriceCode;
import main.Program;
import main.Customer;

public class ProgramTest 
{
	@Test
	public void getStatementTesta()
	{
		String expected = 	"Rental Record for joe\n" + 
							"	Title		Days	Amount\n" + 
							"	movie1		10	30.0\n" + 
							"	movie2		5	4.5\n" + 
							"Amount owed is 34.5\n" + 
							"You earned 3 frequent renter points";
		
        Movie m1 = new Movie("movie1", PriceCode.NEW_RELEASE);
        Movie m2 = new Movie("movie2", PriceCode.CHILDRENS);
        Customer c1 = new Customer("joe");  
        c1.rentAMovie(m1, 10);
        c1.rentAMovie(m2, 5);

        System.out.println(expected);
        System.out.println(Program.getStatement(c1));
        
		Assert.assertEquals(expected, Program.getStatement(c1));
	}

}
