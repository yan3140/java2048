import java.util.Random;
import java.util.Scanner;

public class demo {
    public static final int SIZE = 4;
    public static void main(String[] args) {
        int[][] a = new int[SIZE][SIZE];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 0;
            }
        }
        boolean i = true;
        System.out.println("游戏开始");
        randomNumberGenerator(a);
        printArray(a);
        while (true) {
            if(processJudge(a)) {
                Scanner sc = new Scanner(System.in);
                switch (sc.next()) {
                    case "a":
                        left_move(a);
                        randomNumberGenerator(a);
                        printArray(a);
                        continue;
                    case "d":
                        right_move(a);
                        randomNumberGenerator(a);
                        printArray(a);
                        continue;
                    case "w":
                        up_move(a);
                        randomNumberGenerator(a);
                        printArray(a);
                        continue;
                    case "s":
                        down_move(a);
                        randomNumberGenerator(a);
                        printArray(a);
                }
            }else {
                System.out.println("失败，游戏终止。");
                break;
            }
        }

    }
    //打印数组
    public static void printArray(int[][] a){
        System.out.println("分数:"+score(a));
        for (int i = 0; i < a.length; i++) {
           for (int j = 0; j < a[i].length; j++) {
               if(j==3){
                   System.out.println(a[i][j]);
               }else {
                   System.out.print(a[i][j] + "  ");
               }
           }
        }
        System.out.println("--------");
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
    public static int[] left_merge(int[] a){
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
        return merged;
        }
    //向右移动
    public static int[][] right_move(int[][] array){
        for (int i = 0; i < SIZE; i++) {
            array[i] = reverse(array[i]);
            array[i] = left_merge(array[i]);
            array[i] = reverse(array[i]);
        }
        return array;
    }
    //翻转
    private static int[] reverse(int[] array) {
        int[] reversed = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            reversed[i] = array[SIZE - 1 - i];
        }
        return reversed;
    }
    //向左移动
    private static int[][] left_move (int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            array[i]=left_merge(array[i]);
        }
        return array;
    }
    //向上移动
    private static int[][] up_move (int[][] array) {
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
        return (array);
    }
    //向下移动
    private static int[][] down_move (int[][] array) {
        for (int i = 0; i < SIZE; i++) {
            int [] a =new int [SIZE];
            for (int j = 0; j < SIZE; j++) {
                a[j]=array[j][i];
            }
            a =reverse(a);
            a = left_merge(a);
            int []b=reverse(a);
            for(int j=0;j<SIZE;j++){
                array[j][i]=b[j];
            }
        }
        return array;
    }
    //分数计算
    private static int score  (int[][] array) {
        int max = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
    //进程判断
    private static boolean processJudge(int[][] array) {
       int[][] a = left_move(array);
       int[][] b = up_move(array);
       int[][] c = down_move(array);
       int[][] d = right_move(array);
       if(compare(a,array) && compare(b,array) && compare(c,array) && compare(d,array)){
           return false;
       }
       return true;
    }
    //compare
    private static boolean compare(int[][] a, int[][] b) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
