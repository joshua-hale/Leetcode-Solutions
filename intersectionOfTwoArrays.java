class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        Set<Integer> result = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] final = new int[result.size()];
        int i = 0;
        for (int num : result) {
            final[i++] = num;
        }

        return final;
    }
}
