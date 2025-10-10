import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int best = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int localBest = 0;

                while (set.contains(current)) {
                    localBest += 1;
                    current += 1;
                }

                best = Math.max(best, localBest);
            }
        }

        return best;
    }
}
