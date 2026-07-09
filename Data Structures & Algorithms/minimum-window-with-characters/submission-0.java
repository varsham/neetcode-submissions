class Solution {
    public String minWindow(String s, String t) {
        // create a frequency map for characters in t
        Map<Character, Integer> freqT = new HashMap<>();

        // populate the frequency map for characters in t
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        // initialize a window to keep track of the current characters in the substring
        Map<Character, Integer> window = new HashMap<>();

        // initialize a left pointer
        int l = 0;

        // initialize a "have" characters count and a "need" characters count
        int have = 0, need = freqT.size();

        // initialize a result array and length
        int resLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};

        // initialize a right pointer and loop through the length of the string
        for (int r = 0; r < s.length(); r++) {
            char rC = s.charAt(r);
            // add characters to window's frequency map
            // window keeps track of the character frequency in the current map
            window.put(rC, window.getOrDefault(rC, 0) + 1);

            // check if "have" needs to be incremented
            if (freqT.containsKey(rC) && window.get(rC).equals(freqT.get(rC))) {
                have++;
            }

            // check if "have" == "need" now that "have" has been appropriately updated
            while (have == need) {
                // update the current length if it's smaller than the previous in length
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                // then perform the checks to increment the left pointer
                // reduce the left pointer's character frequency in the current window
                window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                // check to see if we need that character
                if (freqT.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < freqT.get(s.charAt(l))) {
                    have--;
                }

                // now that have has been updated and all the checks have been performed, increment l
                l++;
            }
        }

        if (resLen == Integer.MAX_VALUE) return "";
        else return s.substring(res[0], res[1] + 1);

        // within the loop:
        // add characters to the window frequency map
        // check if that character's (at the right pointer) frequency in the window frequency map 
        // is equal to that character's frequency

        // if it is, then increment the "Have" characters

        // check if have == need
        // if the have characters is the same as the need, then use a while loop to increment the
        // left pointer to reduce the window size as much as possible while keeping have == need
            // first, check if the current window is actually less than the previous smallest window
            // if so, then update the result window to return

            // then, perform the checks for incrementing the left pointer
            // reduce the frequency for the character at that left pointer
            // check if the character at the left pointer is in counT, and if the frequency is less
            // than the count T frequency

            // if so, then decrement have, because you lost a character you need
            // increment the left pointer
    }
}
