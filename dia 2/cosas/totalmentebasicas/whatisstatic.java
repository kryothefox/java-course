package cosas.totalmentebasicas;

class coolClass{
    int randomNum1 = 7;
    static int randomNum2 = 20;
}

public class whatisstatic {
    
    public static void main(String[] args) {
        //coolClass.randomNum1 //compiler error, randomNum1 is not exposed when not an object
        coolClass cC = new coolClass();
        System.out.println(cC.randomNum1); // now exposed, as an object
        //System.out.println(cC.randomNum2); // redundant but still valid
        coolClass.randomNum2++;
        cC.randomNum1++;
        coolClass cC2 = new coolClass();
        System.out.println(cC2.randomNum1); // 7
        System.out.println(coolClass.randomNum2); // 21 
        
    }
}
