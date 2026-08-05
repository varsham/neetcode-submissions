class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            g.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            g.get(p[0]).add(p[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) return false;
        }

        return true;
    }

    private boolean dfs(int c) {
        // cycle detected
        if (visited.contains(c)) return false;
        // check if no prerequisites
        if (g.get(c).isEmpty()) return true;

        // loop through the prerequisites to check if there is a cycle
        visited.add(c);
        for (int n : g.get(c)) {
            if (!dfs(n)) return false; 
        }

        visited.remove(c); // reset the visited array for the next dfs run
        g.put(c, new ArrayList<>());
        return true;
    }
}
