class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while (right < s.length()) {
            char current = s.charAt(right);

            if(map.containsKey(current) && map.get(current) >= left) {
                left = map.get(current) + 1;
            }

            map.put(s.charAt(right), right);
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }

        return maxLength;
    }
}
