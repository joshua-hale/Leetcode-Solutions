class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}

// O(1) Space and O(n) time solution
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // Expected sum of numbers from 0 to n
        int expectedSum = n * (n + 1) / 2;

        // Actual sum of the array
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // The missing number is the difference
        return expectedSum - actualSum;
    }
}
