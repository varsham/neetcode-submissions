class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int i = 0;
        int curP = 0;
        int[] prefixes = new int[words.length];

        Character[] v = {'a', 'e', 'i', 'o', 'u'};
        HashSet<Character> vowels = new HashSet<>(Arrays.asList(v));

        for (int w = 0; w < words.length; w++) {
            String word = words[w];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                curP++;
            }
            prefixes[i] = curP;
            i++;
        }

        for (int k = 0; k < prefixes.length; k++) System.out.print(prefixes[k] + " ");

        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            if (queries[j][0] == 0) result[j] = prefixes[queries[j][1]];
            else result[j] = prefixes[queries[j][1]] - prefixes[queries[j][0] - 1];
        }
        
        return result;
    }
}