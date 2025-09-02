import java.util.Random;

public class demo {
    public static final int SIZE = 4;
    public static void main(String[] args) {
        int [][]a = new int [SIZE][SIZE];
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
    public void printArray(int[][] a){
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
        int m = 0,n = 0,k = 0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(a[i][j]==0){
                    k ++;
                }
            }
        }
        if(k<2){return a;
        }else {for (int i = 0; i < 2; i++) {
                for (int b = 1; b > 0; b++) {
                    m = rand.nextInt(4);
                    n = rand.nextInt(4);
                    if (a[m][n] == 0) {
                        break;
                    }
                }

                int q = rand.nextInt(3);
                if (q == 2) {
                    a[m][n] = 4;
                } else {
                    a[m][n] = 2;
                }
            }
            return a;
        }
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
    //向右移动
    public void right_merge(int[][] array){
        for (int i = 0; i < SIZE; i++) {
            reverse(array[i]);
            left_merge(array[i]);
            array[i]=reverse(array[i]);
        }
        printArray(array);
    }
    //翻转
    private int[] reverse(int[] array) {
        int[] reversed = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            reversed[i] = array[SIZE - 1 - i];
        }
        return reversed;
    }
    //向左移动
    private void left_move (int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            array[i]=left_merge(array[i]);
        }
        printArray(array);
    }
    //向上移动
    private void up_move (int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            int [] a =new int [SIZE];
            for (int j = 0; j < SIZE; j++) {
                a[j]=array[j][i];
            }
            int []b=left_merge(a);
            for(int j=0;j<SIZE;j++){
                array[j][i]=b[j];
            }
        }
        printArray(array);
    }
    //向下移动
    private void down_move (int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            int [] a =new int [SIZE];
            for (int j = 0; j < SIZE; j++) {
                a[j]=array[j][i];
            }
            reverse(a);
            left_merge(a);
            int []b=reverse(a);
            for(int j=0;j<SIZE;j++){
                array[j][i]=b[j];
            }
        }
        printArray(array);
    }
}
