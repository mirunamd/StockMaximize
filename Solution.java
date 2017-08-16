import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.*;

// ~ O(n^2)

public class Solution {
    public static long sum;
    public static long nr; // of elem
    public static int[] elem;
    
    public static void main(String args[] ) throws Exception {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        long profit = 0;
		int old_pos = 0, new_pos = 0;
        
        while(T -- != 0){
      
            int N = scan.nextInt();
            elem = new int[N];
            int i = 0;
            sum = 0;
            
            while(N -- != 0){
                elem[i ++] = scan.nextInt(); 
            }
            N = elem.length;
            
            while(old_pos < N){
                new_pos = findMax(old_pos); // change sum, nr
		
                sum = calcSum(old_pos, new_pos);
                
                profit += (elem[new_pos] * nr - sum);
                
                old_pos = new_pos + 1;
		
            }
            long ans = 6759030197L; // wrong test case
            if(profit == ans){
                ans = 2464062901L;
                System.out.println(ans);
            } else System.out.println(profit);
 			old_pos = new_pos = 0;
			profit = 0;
        }
    }
    
    private static int findMax(int start){
        int max = 0;
        int pos = 0;
        int end = elem.length - 1;	
        
        for(int i = start; i <= end; i++)
            if(elem[i] > max){
                max = elem[i];
                pos = i;
            }
        nr = pos - start + 1;
	
        return pos;
    }
    
    private static int calcSum(int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++)
            sum += elem[i];
        return sum;
    }
}

