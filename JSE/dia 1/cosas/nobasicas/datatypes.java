package cosas.nobasicas;

public class datatypes {
    public static void main(String[] args) {

        

        byte someRandomByte = 127;
        short aShortNumber = 32600;
        int aBigInt = Integer.MAX_VALUE;
        long veryLong = 5892735892378572389L;
        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;

       
        
        // working with type castings

        // **** TYPE PROMOTION ****
       
            byte aRandomByte = 127;

            int someInt = aRandomByte; //promoting the type limits
        
        // **** TYPE CASTING ****


        int aLargeInt = 523785;

        byte theOverflowedByte = (byte) aLargeInt;

        //System.out.println("Huston, there is an overflow!\nbyte: " + theOverflowedByte);

        short theShorterOverflow = (short) aLargeInt;

        //System.out.println("Another overflow :" + theShorterOverflow);
        

        
        // **** TYPE PARSING ****

        String stringedNumber = "5358237";

        double doublingTheFloat = Double.parseDouble(stringedNumber);

        Double.parseDouble(stringedNumber);
        Float.parseFloat(stringedNumber);



        // **** DECIMAL NUMBERS ****

        float someFloatNumber = 50.5f;

        //System.out.println(someFloatNumber);
        
        double aLargeDouble = 3_857_289_357.3523f;

        //System.out.println(aLargeDouble);
        
        // **** DIVISION OF FLOATS ****

        float largeFloat = 5128f;

        int smallInt = 14;

        //System.out.println((float)largeFloat/smallInt);
        //System.out.println("higher precision?\n" + (double)largeFloat/smallInt);
        //System.out.println("kill the decimal!\n" + (int)largeFloat/smallInt);

        // **** THE CHARacter ****

        
        char aLetter = 'O';

        char aHexLetter = 0x77;
        
        char aDecimalLetter = 79;

        char aUnicode = '\u4002';
        /*
        System.out.println(aLetter);
        System.out.println(aHexLetter);
        System.out.println(aDecimalLetter);
        //uncomment for surprise
        */

        /* 
        System.out.println(Character.isAlphabetic(aHexLetter));
        System.out.println(Character.compare(aHexLetter,aDecimalLetter));
        System.out.println(aUnicode);
        */

        // **** BOOLEAN ****

        boolean aLiterallyFalseBoolean = false;

        boolean aLiterallyTrueBoolean = Boolean.TRUE;

        boolean trueOrFalse = aLiterallyFalseBoolean == false && aLiterallyTrueBoolean == true;

        //System.out.println(trueOrFalse);

    }
}
