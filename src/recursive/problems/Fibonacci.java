//366. Fibonacci
//        中文English
//        Find the Nth number in Fibonacci sequence.
//
//        A Fibonacci sequence is defined as follow:
//
//        The first two numbers are 0 and 1.
//        The i th number is the sum of i-1 th number and i-2 th number.
//        The first ten numbers in Fibonacci sequence is:
//
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
//
//        样例
//        Example 1:
//        Input:  1
//        Output: 0
//
//        Explanation:
//        return the first number in  Fibonacci sequence .
//
//        Example 2:
//        Input:  2
//        Output: 1
//
//        Explanation:
//        return the second number in  Fibonacci sequence .

package recursive.problems;

public class Fibonacci {
    //remember to ask where the input n th fibonacci will exceed integer upper bound

    public static long fibonacci(int n) {
        // memorization of calculated fibonacci result
        // reduce the complexity to O(n)
        if(n==0) return 0;
        if(n <= 2) return n-1;
        long[] cache = new long[n+1];
        cache[0]=0;
        cache[1]=0;
        cache[2]=1;
        long result = helper(n-1,cache) + helper(n-2, cache);
        return result;
    }

    private static long helper(int n, long[] cache) {
        if(n==1) return 0;
        if(cache[n] > 0) return cache[n];
        cache[n] = helper(n-1, cache) + helper(n-2, cache);
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(50));
    }
}
