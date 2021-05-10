package main;

import java.lang.*;
import java.util.*;
/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compilr IDE, only applets can.
 */
public class Program
{
    /**
     * This is the main entry point for the application
     */
    
    
    public static void main(String args[]) 
    {
        String result;
        System.out.println("Welcome to the Movie Store");
        Movie m1 = new Movie("movie1", PriceCode.NEW_RELEASE);
        Movie m2 = new Movie("movie2", PriceCode.CHILDRENS);
        Customer c1 = new Customer("joe");  
        c1.rentAMovie(m1, 10);
        c1.rentAMovie(m2, 5);
        System.out.println("Let's get the Statement");
        result = c1.statement();
        System.out.println(result);
    }
}

