
import java.time.LocalTime;
import java.util.Arrays;

public class sentencecalculator {
    public static void main(String[] message) {
        
        
        final int LOWERCASE_RANGE_LOW = 97;
        final int LOWERCASE_RANGE_MAX = 122; // a-z
        
        final int UPPERCASE_RANGE_MAX = 90;
        final int UPPERCASE_RANGE_LOW = 65; // A-Z

        final Character[] LOWERCASE_LETTERS = new Character[(LOWERCASE_RANGE_MAX - LOWERCASE_RANGE_LOW) + 1];
        final Character[] UPPERCASE_LETTERS = new Character[(UPPERCASE_RANGE_MAX - UPPERCASE_RANGE_LOW) + 1];
        
        final Character[] NUM_ARR = new Character[10];

        final int[] LOWERCASE_SCORES = new int[(LOWERCASE_RANGE_MAX - LOWERCASE_RANGE_LOW) + 1];
        final int[] UPPERCASE_SCORES = new int[(UPPERCASE_RANGE_MAX - UPPERCASE_RANGE_LOW) + 1];


        /*
         * going through all the letters on the table, saved another loop by
         * just adding the 32 offset on the ascii table
         * 
        */

        int n = 0;
        for (int i = LOWERCASE_RANGE_LOW; i <= LOWERCASE_RANGE_MAX; i++) {
            LOWERCASE_LETTERS[n] = (char) i;
            UPPERCASE_LETTERS[n] = (char) (i - 32);
            
            LOWERCASE_SCORES[n] = n + 1;
            UPPERCASE_SCORES[n] = (n + 1) * 2;
            n++;
        }

        /*
         * there is definitely a more efficient way to do this!!!!
        */

        for (int i = 0; i <= 9; i++) {
            NUM_ARR[i] = (char) (48 + i);
            // yes we are filling it with ascii characters, saves time in search
        }
        

        double score = 0;

        // char[] testMessage = message[0];
        String testMessage = "Welcome to the jungle."; // efficiency testing purposes

        LocalTime timestamp1 = LocalTime.now();
        
        for (char c : testMessage.toCharArray()) {
            
            // just recursing through all the arrays for each character, i think i can make
            // this even more efficient

            // UPPERCASE/LOWERCASE/DIGIT searches
            if (Character.isUpperCase(c)) {
                int upperBSearch = Arrays.binarySearch(UPPERCASE_LETTERS, c);
                // BINARY SEARCH RETURNS THE INDEX
                if (upperBSearch >= 0) {
                    score += UPPERCASE_SCORES[upperBSearch];
                }
                continue;
                // adding continue to make search time less than 3 times every iteration
            } else if (Character.isLowerCase(c)) {
                int lowerBSearch = Arrays.binarySearch(LOWERCASE_LETTERS, c);
                if (lowerBSearch >= 0) {
                    score += LOWERCASE_SCORES[lowerBSearch];
                }
                continue;
            } else if (Character.isDigit(c)) {
                int numberBSearch = Arrays.binarySearch(NUM_ARR, c);
                if (numberBSearch >= 0) {
                    score += numberBSearch;
                }
                continue;
            }
        }
        
        //System.out.println("message: \n" + String.valueOf(testMessage));
        System.out.println("score: \n" + score);
        LocalTime timestamp2 = LocalTime.now();
        int timeElapsed = timestamp2.getSecond()-timestamp1.getSecond();
        System.out.println("time elapsed: \n" + timeElapsed + 's');
        //return score

    }
}
