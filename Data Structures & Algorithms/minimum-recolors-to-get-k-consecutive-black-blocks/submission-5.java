class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, swaps = 0, res = Integer.MAX_VALUE;
        while (l <= r && r < blocks.length()) {
            if (blocks.charAt(r) == 'W') swaps++;
            int len = r - l + 1;
            if (len >= k) {
                if (len == k) res = Math.min(res, swaps);
                if (blocks.charAt(l) == 'W') swaps--;
                l++;
            }
            r++;
        }   

        return res;
    }
}