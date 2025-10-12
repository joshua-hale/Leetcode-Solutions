class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length();

        while (right < s2.length()) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            } else {
                s2Count[s2.charAt(right) - 'a']++;
                s2Count[s2.charAt(left) - 'a']--;

                right++;
                left++;
            }
        }

        return Arrays.equals(s1Count, s2Count);
    }
}
