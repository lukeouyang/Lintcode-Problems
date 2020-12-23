/*
607. Two Sum III - Data structure design
中文English
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

样例
Example 1:

add(1); add(3); add(5);
find(4) // return true
find(7) // return false
 */

package array.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSumClass {
    /**
     * @param number: An integer
     * @return: nothing
     */
    /**
     * @param number: An integer
     * @return: nothing
     */
    private static Map<Integer, Integer> data = new HashMap<>();
    public void add(int number) {
        if(data.containsKey(number)) {
            data.put(number, data.get(number) + 1);
        } else {
            data.put(number,1);
        }
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for(Integer key : data.keySet()){
            int target = value - key;
            if(target*2 == value) {
//                System.out.print(target + "-"+data.get(target));
                if(data.get(target) > 1) return true;
            } else {
                if(data.containsKey(target)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumClass my2sum = new TwoSumClass();
        my2sum.add(2);
        my2sum.add(3);
        if(my2sum.find(4)) System.out.println("true"+4);
        else System.out.println("false"+4);
        if(my2sum.find(5)) System.out.println("true"+5);
        else System.out.println("false"+5);
        if(my2sum.find(6)) System.out.println("true"+6);
        else System.out.println("false"+6);
        my2sum.add(3);
        if(my2sum.find(6)) System.out.println("true"+6);
        else System.out.println("false"+6);
    }
}
