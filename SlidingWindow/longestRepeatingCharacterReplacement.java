class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];       
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int best = 0;


        while (right < s.length()) {
            int letter = s.charAt(right) - 'A';
            freq[letter]++;
            maxCount = Math.max(maxCount, freq[letter]);

            while ((right - left + 1) - maxCount > k) {
            freq[s.charAt(left) - 'A']--;
            left++;
            }

            best = Math.max(best, right - left + 1);
            right++;
        }

        return best;
    }
}
