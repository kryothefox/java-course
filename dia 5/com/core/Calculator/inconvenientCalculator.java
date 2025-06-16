package com.core.Calculator;

import java.util.NoSuchElementException;

import com.core.Errors.zeroOnSecondValue;

public class inconvenientCalculator {

    public double subtract(double a, double b)
        throws ArithmeticException,
            NumberFormatException,
            NullPointerException,
            NoSuchElementException,
            zeroOnSecondValue {

            if(b == 0.0){throw new zeroOnSecondValue();};
            return (a - b);
        }
    
        public double add (double a, double b)
        throws ArithmeticException,
            NumberFormatException,
            NullPointerException,
            NoSuchElementException,
            zeroOnSecondValue{
            if(b == 0.0){throw new zeroOnSecondValue();};
            return (a + b);
        }
}
