class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) return s.length();
        // brute force
        // go through, loop through the string

        int maxStreak = 0;

        StringBuilder curString = new StringBuilder();
        
        // loop through the characters
        for (int i = 0; i < s.length(); i++) {
            int index = curString.indexOf(String.valueOf(s.charAt(i)));
            if (index >= 0) {
                maxStreak = Math.max(curString.length(), maxStreak);
                curString.delete(0, index + 1);
            }
            curString.append(String.valueOf(s.charAt(i)));
        }

        return Math.max(curString.length(), maxStreak);
    }
}
