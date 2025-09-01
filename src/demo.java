import java.util.Random;

public class demo {
    public static final int SIZE = 4;
    public static void main(String[] args) {
        int [][]a = new int [4][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 0;
            }

        }
        randomNumberGenerator(a);
//        printArray(a);
//        System.out.println("-------------");
//        randomNumberGenerator(a);
//        printArray(a);
//        System.out.println("-------------");
//        randomNumberGenerator(a);
//        printArray(a);
//        System.out.println("-------------");

    }
    //打印数组
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
    //随机数生成
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
    //向左合成
    public int[] left_merge(int[] a){
        int[] b = new int[a.length];
        int m = 0;
        for (int i : a) {
            if(i!=0){
                b[m++]=i;
            }
        }
        int [] merged=new int[SIZE];
        for(int i=0;i<SIZE;i++){
            if(i<SIZE-1 && b[i]!=0 && b[i+1]==b[i]){
                merged[i]=2*b[i];
                i++;
            }else{
                merged[i] = b[i] != 0 ? b[i] : 0;
            }
        }
        for (int i : merged) {
            System.out.println(i);
        }
        return merged;
        }
    public int[] right_merge(int[] a){
        reverse(a);
        left_merge(a);
        reverse(a);
        return a;
    }
    //翻转
    private int[] reverse(int[] array) {
        int[] reversed = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            reversed[i] = array[SIZE - 1 - i];
        }
        return reversed;
    }
}
