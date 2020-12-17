//Valid Palindrome II
//        描述
//        Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//
//        The string will only contain lowercase characters.
//        The maximum length of the string is 50000.
//        说明
//        样例
//        Example 1:
//
//        Input: s = "aba"
//        Output: true
//        Explanation: Originally a palindrome.
//        Example 2:
//
//        Input: s = "abca"
//        Output: true
//        Explanation: Delete 'b' or 'c'.
//        Example 3:
//
//        Input: s = "abc"
//        Output: false
//        Explanation: Deleting any letter can not make it a palindrome.

package string.problems;

public class ValidPalindromeDeleteOne {
    static class Pair {
        int left;
        int right;
        public Pair(int l, int r) {
            this.left = l;
            this.right = r;
        }
    }

    public static boolean validPalindrome(String s) {
        if(isPalindrome(s)) return true;
        Pair diff = findTheDiff(s);
        if(diff.left == diff.right) return true;
        else{
            return isPalindrome(s.substring(diff.left+1,diff.right+1)) || isPalindrome(s.substring(diff.left,diff.right));

        }
    }

    public static Pair findTheDiff(String s) {
        int left = 0;
        int right = s.length()-1;

        if(left == right) return new Pair(left, right);

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return new Pair(left, right);
            left++;
            right--;
        }
        return new Pair(0, 0);
    }

    public static boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        if(s.length()==1) return true;
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;


    }

    public static void main(String[] args) {
        String input1 = "abba";
        String input2 = "abca";
        String input3 = "abcdyba";

        System.out.println(validPalindrome(input1));
        System.out.println(validPalindrome(input2));
        System.out.println(validPalindrome(input3));

    }
}
