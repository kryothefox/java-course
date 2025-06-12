import java.util.Arrays;

public class vowelcalc {
    public static void main(String[] args) {
        
        final char[] VOWELS = {'a','e','i', 'o','u'};

        int numVowels = 0;
        StringBuilder theMessage = new StringBuilder(args[0]);


        for(char ch : String.valueOf(theMessage).toCharArray()){
            if(Arrays.binarySearch(VOWELS, ch) >= 0){
                numVowels++;
            }
        }

        System.out.println(args[0] + " score: " + numVowels);

    }
}
