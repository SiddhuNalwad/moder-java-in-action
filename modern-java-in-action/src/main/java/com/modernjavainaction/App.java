package com.modernjavainaction;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IntStream.rangeClosed(1,15).anyMatch(App::isNotDivisible);
        
        float price = 9.0f;
        double fractionPart = price % 1.0;
        System.out.println(fractionPart);
    }
    
    static boolean isNotDivisible(int n) {
    	return ((n % 3 == 0) || (n % 5 == 0) || (n %3 == 0 && n % 5 == 0));
    }
}
