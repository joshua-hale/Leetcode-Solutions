class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[128];

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        int start = 0;
        int left = 0;
        int right = 0;
        int missing = t.length();
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            if (tCount[rightChar] > 0) {
                missing--;
            }

            tCount[rightChar]--;

            while (missing == 0) {
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }

                char leftChar = s.charAt(left);
                tCount[leftChar]++;

                if (tCount[leftChar] > 0) {
                    missing++;
                }

                left++;
            }

            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
