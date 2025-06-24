package cosas.nobasicas;
public class methods {
    public static void main(String[] args) {
        
        // it's static, no need to initialize the method
        double addedNum = add(15, 123);
        
        // non static
        double sillyNumber = new methods().divideAndSquare(10, 2);

        System.out.println(addedNum);
        System.out.println(sillyNumber);
        
    }

    // **** add function, public and static with double return type ****
    public static double add(int x, int y){
        return x + y;
    } 


    public double divideAndSquare(int num1, int num2){
        double divided = num1/num2;
        
        return Math.pow(divided,2);

    }

}
