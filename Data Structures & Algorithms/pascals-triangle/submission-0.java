class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int n = 1; n < numRows; n++) {
            List<Integer> temp = new ArrayList<>(result.get(n - 1));
            temp.add(0, 0);
            temp.add(0);

            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < temp.size() - 1; i++) {
                row.add(temp.get(i) + temp.get(i + 1));
            }

            result.add(row);
        }

        return result;
    }
}