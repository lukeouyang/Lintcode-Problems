/*
415. Valid Palindrome
中文English
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

样例
Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama"
Example 2:

Input: "race a car"
Output: false
Explanation: "raceacar"
挑战
O(n) time without extra memory.

注意事项
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */



package string.problems;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        // head tail pointer moving towards each other
        // ask the value to return if s is null or empty
        // ask for agreement about what is a palindrome
        // ask what operation will conduct on those non-valid letter in the String
        if(s == null) return false;
        if(s.equals("")) return true;

        int head = 0, tail=s.length()-1;
        while(head < tail){
            if (head >=s.length() || tail < 0) break;
            if (!isValidCharacter(s.charAt(head))) {
                head += 1;
                continue;
            }
            if (!isValidCharacter(s.charAt(tail))) {
                tail -= 1;
                continue;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) return false;
            if (head == tail) break;
            head++;
            tail--;
        }

        return true;


    }

    public static boolean isValidCharacter(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(input));
    }
}
