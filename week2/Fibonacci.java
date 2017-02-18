import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
public class Solution {
  public static void main(String[] args) throws IOException{
    
    
    Scanner s = new Scanner(System.in);
    String[] line = s.nextLine().split(" ");
    BigInteger A = BigInteger.valueOf(Byte.parseByte(line[0]));
    BigInteger B = BigInteger.valueOf(Byte.parseByte(line[1]));
    
   
    for(byte n = (byte)(Byte.parseByte(line[2]) - 2); n > 0; --n){
      BigInteger C = B.multiply(B).add(A);
      A = B;
      B = C;
    }
    
    
    System.out.print(B);
  }
}
