class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int key : map.keySet()) {
        if (map.get(key) > nums.length / 3) {
            result.add(key);
            }
        }

        return result;
    }
}

// Boyer Moore Solution
import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 1) Find up to two candidates
        Integer c1 = null, c2 = null;
        int cnt1 = 0, cnt2 = 0;

        for (int x : nums) {
            if (Objects.equals(c1, x)) {
                cnt1++;
            } else if (Objects.equals(c2, x)) {
                cnt2++;
            } else if (cnt1 == 0) {
                c1 = x; cnt1 = 1;
            } else if (cnt2 == 0) {
                c2 = x; cnt2 = 1;
            } else {
                cnt1--; cnt2--;
            }
        }

        // 2) Verify counts (candidates may be null or invalid)
        cnt1 = 0; cnt2 = 0;
        for (int x : nums) {
            if (Objects.equals(c1, x)) cnt1++;
            else if (Objects.equals(c2, x)) cnt2++;
        }

        int thr = nums.length / 3;
        List<Integer> res = new ArrayList<>(2);
        if (c1 != null && cnt1 > thr) res.add(c1);
        if (c2 != null && !Objects.equals(c2, c1) && cnt2 > thr) res.add(c2);
        return res;
    }
}

