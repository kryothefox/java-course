package cosas.totalmentebasicas;
public class arrays {
    public static void main(String[] args) {
        
        //DECLARE ARRAY WITH N SIZE
        int n = 10;
        String[] names = new String[n];
        int[] ages = new int[n];
        //System.out.println(names[0]); // NULL
        //System.out.println(ages[0]); // 0
        names[0] = "John";
        ages[0] = 18;
        //System.out.println(names.length);
        //System.out.println(ages.length); // SIZE IS STILL N, EVEN AFTER ASIGNATION
        
        //System.err.println(names[0]+ ages[0]);
        
        //DECLARE ARRAY WITH ELEMENTS INSIDE    
        
        String[] names2 = new String[]{"John","Doe"};
        int[] ages2 = new int[]{18};
        //System.out.println(names2.length); // SIZE IS 2
        //names2[3] = "Jane"; //COMPILE ERROR
        
        //MULTIDIMENSIONAL ARRAY
        int[][][] numArr = new int[][][]{
            {
                {10,50}
            },
            {
                {40,20}
            },
            {
                {10,70}
            },
        };

        System.out.println(numArr[0][0][0]);

    }
}
