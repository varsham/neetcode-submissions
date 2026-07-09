class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;

        // increment through to find the characters to "keep"
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) continue;
            char c = s.charAt(i);

            int l = 0, count = 0;
            // l = left pointer
            // count keeps track of the number of characters c
            for (int r = 0; r < s.length(); r++) {
                // keep incrementing and updating count accordingly
                if (s.charAt(r) == c) count++;

                // for each of these windows:
                // check to see if the number of replacements required is greater than k
                while ((r - l + 1) - count > k) {
                    // if so, then move the left pointer forward until you get the right number of replacements
                    // also update count accordingly
                    if (s.charAt(l) == c) count--;
                    l++;
                }

                result = Math.max(result, r - l + 1);
            }
        }

        return result; 
    }

    
}