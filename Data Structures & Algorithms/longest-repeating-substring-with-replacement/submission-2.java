class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // skip duplicate characters that might be next to each other
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            char curC = s.charAt(i);

            // for each character, construct a window
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                // update count accordingly based on the right pointer
                if (s.charAt(r) == curC) count++;

                // check if the current window matches the problem specifications
                // if not, then update the left pointer so it does
                while ((r - l + 1) - count > k) {
                    // update count accordingly
                    if (s.charAt(l) == curC) count--;
                    l++;
                }

                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }

    
}