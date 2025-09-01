import java.util.Random;

public class demo {
    public static void main(String[] args) {
        int [][]a = new int [4][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 0;
            }
        }
        randomNumberGenerator(a);
        printArray(a);
        System.out.println("-------------");
        randomNumberGenerator(a);
        printArray(a);
        System.out.println("-------------");
        randomNumberGenerator(a);
        printArray(a);
        System.out.println("-------------");

    }
    public static void printArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
           for (int j = 0; j < a[i].length; j++) {
               if(j==3){
                   System.out.println(a[i][j]);
               }else {
                   System.out.print(a[i][j] + " ");
               }
           }
        }
    }
    public static int[][] randomNumberGenerator(int[][]a){
        Random rand = new Random();
        int m = 0,n = 0;
        for (int i = 0; i < 2; i++) {
            for(int b=1;b>0;b++){
                m = rand.nextInt(4);
                n = rand.nextInt(4);
                if(a[m][n]==0) {
                    break;
                }
            }

            int k = rand.nextInt(3);
            if(k==2){
                a[m][n]=4;
            }else {
                a[m][n]=2;
            }
        }
        return a ;
    }
    public static void upMove(){
        

    }
}
