/* *
627. Longest Palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.
* */
package string.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if(s == null)return 0;
        if(s.length() < 2) return s.length();

        Set oddLet  = new HashSet<Character>();
        char[] input = s.toCharArray();
        for (char i : input) {
            if (oddLet.contains(i)) {
                oddLet.remove(i);
            } else {
                oddLet.add(i);
            }
        }
        if (oddLet.size() ==0) return s.length();
        else return s.length()-oddLet.size()+1;
    }

    public static void main(String[] args){
        String input = "abccccdd";
        System.out.println(longestPalindrome(input));

    }
}
