package PJ1;

/*  This program is used to test PJ1.Fracition class
 *  More info are given in Readme file
 */

import java.util.*;
import PJ1.*;

class PJ1_Test
{
    static private Scanner scanner;

    private static Fraction readFraction() {
        System.out.print( "\nTry to read a fraction x/y, please enter x y : " );
        int numerator = scanner.nextInt();                            
        int denominator = scanner.nextInt();                          
        Fraction f = new Fraction(numerator, denominator);
        System.out.println( "\t\tRead OK:"+f);
	return f;
    }

    private static void printOperations() {
	System.out.println("==============================================");
        System.out.println("\nOperations:");
        System.out.println("  0) exit \t1) add \t\t2) subtract \t3) multiply \t4) divide");
	System.out.println("  5) compareTo \t6) equals \t7) recipocal \t8) switchSign \t9) getSign ");
        System.out.println("  10) getNumerator       11) getDenominator       12) setFraction (x/y) ");  
        System.out.print( "\nEnter an operation number: ");
    }

    public static void main( String args[] )
    {
       	scanner = new Scanner( System.in ); // scanner for input
       	boolean continueLoop = true; // determines if more input is needed
	Fraction n1=null;
	Fraction n2=null;
	int op,x,y;
  
        do                                                                  
        {                                                                   
           try // read two numbers and calculate quotient                   
           {                                                                
    	      printOperations();
              op= scanner.nextInt();                            

	      if (op == 0) {
		break;
	      } else if ((op >0) && (op <7)) {
		n1 = readFraction();
		n2 = readFraction();
	      } else if ((op > 6) && (op < 12)) {
		n1 = readFraction();
	      } else if (op == 12) {
		n1 = new Fraction();
	      } else if (op == 13) {
		n1 = new Fraction();
	      } else {
                  System.out.print( "\nInvalid input... try again\n" );
		  continue;
	      } 

	      System.out.println("\nTests:\n");
	      switch (op) {
            	case 1:  
			System.out.println("\t" + n1 + " + " + n1 + " = " + n1.add(n1));
            		System.out.println("\t" + n2 + " + " + n2 + " = " + n2.add(n2));
            		System.out.println("\t" + n1 + " + " + n2 + " = " + n1.add(n2));
            		System.out.println("\t" + n2 + " + " + n1 + " = " + n2.add(n1));
		        break;
            	case 2: 
			System.out.println("\t" + n1 + " - " + n1 + " = " + n1.subtract(n1));
            		System.out.println("\t" + n2 + " - " + n2 + " = " + n2.subtract(n2));
            		System.out.println("\t" + n1 + " - " + n2 + " = " + n1.subtract(n2));
            		System.out.println("\t" + n2 + " - " + n1 + " = " + n2.subtract(n1));
		        break;
            	case 3:  
			System.out.println("\t" + n1 + " * " + n1 + " = " + n1.multiply(n1));
            		System.out.println("\t" + n2 + " * " + n2 + " = " + n2.multiply(n2));
            		System.out.println("\t" + n1 + " * " + n2 + " = " + n1.multiply(n2));
            		System.out.println("\t" + n2 + " * " + n1 + " = " + n2.multiply(n1));
		        break;
            	case 4:  
			System.out.println("\t" + n1 + " / " + n1 + " = " + n1.divide(n1));
            		System.out.println("\t" + n2 + " / " + n2 + " = " + n2.divide(n2));
            		System.out.println("\t" + n1 + " / " + n2 + " = " + n1.divide(n2));
            		System.out.println("\t" + n2 + " / " + n1 + " = " + n2.divide(n1));
		        break;
            	case 5:  
			System.out.println("\t" + n1 + " ct " + n1 + " = " + n1.compareTo(n1));
            		System.out.println("\t" + n2 + " ct " + n2 + " = " + n2.compareTo(n2));
            		System.out.println("\t" + n1 + " ct " + n2 + " = " + n1.compareTo(n2));
            		System.out.println("\t" + n2 + " ct " + n1 + " = " + n2.compareTo(n1));
		        break;
            	case 6:  
			System.out.println("\t" + n1 + " eq "+ n1 + " = " + n1.equals(n1));
            		System.out.println("\t" + n2 + " eq "+ n2 + " = " + n2.equals(n2));
            		System.out.println("\t" + n1 + " eq "+ n2 + " = " + n1.equals(n2));
            		System.out.println("\t" + n2 + " eq "+ n1 + " = " + n2.equals(n1));
		        break;
             	case 7:  
			System.out.println("\t" + n1 + " getReciprocal= " + n1.getReciprocal());
		        break;
            	case 8:  
			System.out.print("\t" + n1 );
			n1.switchSign();
			System.out.println(" switchSign - = " + n1);
			System.out.print("\t" + n1 );
			n1.switchSign();
			System.out.println(" switchSign + = " + n1);
		        break;
            	case 9:  
			System.out.println("\t" + n1 + " getSign = " + n1.getSign());
		        break;
            	case 10: 
			System.out.println("\t" + n1 + " getNumerator = " + n1.getNumerator());
		        break;
            	case 11: 
			System.out.println("\t" + n1 + " getDenominator = " + n1.getDenominator());
		        break;
            	case 12: 
        		System.out.print( "read a fraction x/y, please enter x y : " );
        		x = scanner.nextInt();                            
        		y = scanner.nextInt();                          
			System.out.print("\t" + n1 + " setFraction = ");
			n1.setFraction(x,y);
			System.out.println(n1);
		        break;
	      }

           } // end try                                                     
           catch ( ArithmeticException arithmeticException )                
           {                                                                
              System.err.printf( "\nException: %s\n", arithmeticException );
           } // end catch                                                   
        } while ( continueLoop ); // end do...while                         
    } // end main
} // end class DivideByZeroWithExceptionHandling

