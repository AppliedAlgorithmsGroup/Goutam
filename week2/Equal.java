import java.io.*;
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);


        int T = Integer.parseInt(s.nextLine());
        for(int i =0;i<T;i++){
            int N = Integer.parseInt(s.nextLine());
            final int[] A = new int[N];
            String[] input = s.nextLine().split(" ");

            for(int j = 0; j < N; j++){

                A[j] = Integer.parseInt(input[j]);
            }
            input = null;


            if(N < 2){
                System.out.println("0\n");
                continue;
            }

            int minVal = A[0];
            for(int k = 0; k < N; k++){
                if (A[k] < minVal){
                    minVal = A[k];
                }
            }

            int minCount = Integer.MAX_VALUE;
            for( int l = 0; l <= 5; l++){
                int count = 0;
                for(int m = 0; m < N; m++){
                    int V = (A[m] - (minVal - l));
                    count += V/5 + (V %= 5)/2 + (V & 1);
                }
                if (count < minCount){
                    minCount = count;
                }
            }


            System.out.println(minCount);
        }

    }
}