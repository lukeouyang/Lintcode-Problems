/* *
13. Implement strStr()

For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.
* */
package string.problems;

public class ExactSubstringMatching {
    // O(n^2)
    public static int strStr(String source, String target) {
        if (source == null || target == null) return -1;
        if (target.equals("")) return 0;

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            for (int j = 0; j< target.length(); j++) {
                if (target.charAt(j) == source.charAt(i+j)) {
                    if (j == target.length() - 1) return i;
                    continue;
                }
                break;
            }
        }

        return -1;
    }
    // Rabin–Karp algorithm
        public static int mod = 1000000;

        public static int strStr2(String source, String target) {
            if(source == null || target == null) {
                return -1;
            }

            int m = target.length();
            int n = source.length();
            if(m == 0 && source != null) {
                return 0;
            }
            if(n == 0) {
                return -1;
            }

            // mod could be any big integer
            // just make sure mod * 31 wont exceed max value of int.
            int hash_target = 0;

            // 31 could be something else like 26 or whatever you want
            for (int i = 0; i < m; ++i) {
                hash_target = (hash_target * 31 + target.charAt(i)) % mod;
                if (hash_target < 0) {
                    hash_target += mod;
                }
            }

            int m31 = 1;
            for (int i = 0; i < m - 1; ++i) {
                m31 = m31 * 31 % mod;
            }

            int value = 0;
            for (int i = 0; i < n; ++i) {
                if (i >= m) {
                    value = (value - m31 * (source.charAt(i - m))) % mod;
                }

                value = (value * 31 + source.charAt(i)) % mod;
                if (value < 0) {
                    value += mod;
                }

                if (i >= m - 1 && value == hash_target) {
                    // you have to double check by directly compare the string
                    if (target.equals(source.substring(i - m + 1, i + 1))) {
                        return i - m + 1;
                    }
                }
            }
            return -1;

        }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "de";
        System.out.println(strStr2(s,t));

    }
}
