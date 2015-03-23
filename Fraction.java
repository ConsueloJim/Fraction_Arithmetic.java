/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 *      Implement interfaces: FractionInterface and Comparable (i.e. compareTo())
 *      Implement methods equals() and toString() from class Object
 *
 *      Should work for both positive and negative fractions
 *      Must always reduce fraction to lowest term
 *      For number such as 3/-10, it is same as -3/10 (see hints 2. below)
 *      Must display negative fraction as -x/y,
 *         example: (-3)/10 or 3/(-10), must display as -3/10
 *      throws excpetion in case of errors
 *
 *
 ************************************************************************************/
package PJ1;

public class Fraction implements FractionInterface, Comparable<Fraction>
{
	private	int num;	// Numerator	
	private	int den;	// Denominator	

	public Fraction()
	{
		// set fraction to default = 0/1
		setFraction(0, 1);
	}	// end default constructor

	public Fraction(int numerator, int denominator)
	{
                setFraction(numerator, denominator);
	}	// end constructor

	public void setFraction(int numerator, int denominator)
	{
		// return ArithmeticException if initialDenominator is 0
                if (denominator == 0) {
                    throw new ArithmeticException("You cannot divide by 0." +
                           "Please enter another fraction: " );
                }
                num = numerator;
                den = denominator;
                
                
	}	// end setFraction

	public int getNumerator()
	{
		return num;
	}	// end getNumerator

	public int getDenominator()
        {
		return den;
	}	// end getDenominator

	public char getSign()
	{
            if((num / den ) < 0)
                return ('-');
            else
		return('+');
	}	// end getSign

	public void switchSign()
	{
		num = -num;
	}	// change setSign

	public FractionInterface add(FractionInterface secondFraction)
	{
            int newNum = ((num * secondFraction.getDenominator())
                    + (den * secondFraction.getNumerator()));
            int newDen = (den * secondFraction.getDenominator());
            Fraction result = new Fraction(newNum, newDen);
            result.reduceToLowestTerms();
		return result;
	}	// end add

	public FractionInterface subtract(FractionInterface secondFraction)
	{
            int newNum = ((num * secondFraction.getDenominator())
                    - (den * secondFraction.getNumerator()));
            int newDen = (den * secondFraction.getDenominator());
            Fraction result = new Fraction(newNum, newDen);
            result.reduceToLowestTerms();
		return result; 
	}	// end subtract

	public FractionInterface multiply(FractionInterface secondFraction)
	{
            int newNum = (num * secondFraction.getNumerator());
            int newDen = (den * secondFraction.getDenominator());
            Fraction result = new Fraction(newNum, newDen);
            result.reduceToLowestTerms();
		return result; 
	}	// end multiply

	public FractionInterface divide(FractionInterface secondFraction)
	{
            int newNum = (num * secondFraction.getDenominator());
            int newDen = (den * secondFraction.getNumerator());
            Fraction result = new Fraction(newNum, newDen);
            result.reduceToLowestTerms();
            return result;
	}	// end divide

	public FractionInterface getReciprocal() 
	{
            int reciprocal = num;
            num = den;
            den = reciprocal;
		return new Fraction(num, den);
	} // end getReciprocal


	public boolean equals(Object other)
	{
            Fraction second = (Fraction) other;
            int newNum = (num * second.getDenominator());
            int newDen = (den * second.getNumerator());
            if(newNum == newDen)
                return true;
            else 
                return false;
	} // end equals


	public int compareTo(Fraction other)
	{
            if(equals(other) == true)
                return 0;
            else if((num/den) > ((other.getNumerator())
                    / (other.getDenominator())))
                return 1;
            return -1;    
	} // end compareTo

	
	public String toString()
	{
		return num + "/" + den;
	} // end toString


	/** Task: Reduces a fraction to lowest terms. */

        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------

	private void reduceToLowestTerms()
	{
            int GCD = greatestCommonDivisor(num, den);
         
           
                num = num / GCD;
                den = den / GCD;
            
            if(den < 0){
                    den = -den;
                    num = -num;
                }
                // Outline:
                // compute GCD of num & den
                //   greatestCommonDivisor works for + numbers.
                //   So, you should eliminate - sign
                // then reduce numbers : num/GCD and den/GCD
	}	// end reduceToLowestTerms

  	/** Task: Computes the greatest common secondFraction of two integers.
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private int greatestCommonDivisor(int integerOne, int integerTwo)
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = greatestCommonDivisor(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end greatestCommonDivisor


	//-----------------------------------------------------------------
	//  Simple test is provided here 

	public static void main(String[] args)
	{
		FractionInterface firstOperand = null;
		FractionInterface secondOperand = null;
		FractionInterface result = null;

		Fraction nineSixteenths = new Fraction(9, 16);	// 9/16
		Fraction oneFourth = new Fraction(1, 4);        // 1/4

		// 7/8 + 9/16
		firstOperand = new Fraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new Fraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);

		// 15/-2 * 1/4
		firstOperand.setFraction(15, -2);
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);

		// (-21/2) / (3/7)
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(3, 7);
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);

		// -21/2 + 7/8
		firstOperand.setFraction(-21, 2);
		secondOperand.setFraction(7, 8);
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t\t" + result);

		System.out.println();

		// equality check
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand.setFraction(-42, 4);
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		Fraction first  = (Fraction)firstOperand;
		Fraction second = (Fraction)secondOperand;
		
		if (first.compareTo(second) == 0)
			System.out.println("Fractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second.setFraction(7, 8);
		if (first.compareTo(second) < 0)
			System.out.println("Fractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		if (second.compareTo(first) > 0)
			System.out.println("Fractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println();

		try {
			Fraction a1 = new Fraction(1, 0);		    
		}
		catch ( ArithmeticException arithmeticException )
           	{
              		System.err.printf( "\nException: %s\n", arithmeticException );
           	} // end catch

		try {
			Fraction a2 = new Fraction();		    
			Fraction a3 = new Fraction(1, 2);		    
			a3.divide(a2);
		}
		catch ( ArithmeticException arithmeticException )
           	{
              		System.err.printf( "\nException: %s\n", arithmeticException );
           	} // end catch



	}	// end main
} // end Fraction
