class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> u = new HashSet<>();
        for (String e : emails) {
            String[] parts = e.split("@");
            String local = parts[0];

            local = local.split("\\+")[0];
            local = local.replace(".", "");
            u.add(local + "@" + parts[1]);
        }

        return u.size();
    }
}