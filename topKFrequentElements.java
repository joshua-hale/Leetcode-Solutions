import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>(map.keySet());

        uniqueNums.sort((a, b) -> Integer.compare(map.get(b), map.get(a)));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = uniqueNums.get(i);
        }
        return result;
    }
}
