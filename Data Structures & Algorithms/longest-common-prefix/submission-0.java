class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        
        // loop through the first string
        // check each character
        // loop through the rest of the strings and check for the prefix
        boolean toBreak = false;

        for (int i = 0; i < strs[0].length(); i++) {
            char curChar = strs[0].charAt(i); // take the current character
            // no issues with string length because we're looping through characters within the string length

            // loop through each string remaining string
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i == s.length() || s.charAt(i) != curChar) {
                    toBreak = true;
                    break;
                }
            }

            if (toBreak) break;

            prefix += curChar;
        }

        return prefix;
    }
}