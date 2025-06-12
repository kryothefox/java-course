
public class trianglenumberchecker {

    static boolean checkTriangle(long num) {

        double algoDouble = Math.sqrt( ( (8 * num) + 1 ) );


        if (algoDouble % 1 == 0) {
            return true;
        } else {
            return false;
        }

    }

    //public static boolean main(long num) {
    public static void main(String[] args) {
        long randomNum = 53285326;
        System.out.println(checkTriangle(randomNum));
        // return checkTriangle(num);

    }
}
