import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int majority = nums[0];
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (map.get(num) > map.getOrDefault(majority, 0)) {
                majority = num;
            }
        }
        
        return majority;
    }
}
