public class checkxando {
    public static void main(String[] args) {
        
        int numx = 0, numo = 0; 
        char[] argArr = "xxxooo".toCharArray();
        for (Character c : argArr) { 
            if(c.equals('x')){numx++;}else if (c.equals('o')){numo++;}; 
        };
        if(numx == numo){System.out.println(true);}else{System.out.println(false);}

    }
}
