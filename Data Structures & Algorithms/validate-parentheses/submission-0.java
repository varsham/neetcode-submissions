class Solution {
    public boolean isValid(String s) {
        // create a stack to hold characters
        Stack<Character> stack = new Stack<>();
        // key: close
        // value: open
        Map<Character, Character> set = new HashMap<>();
        set.put('}', '{');
        set.put(')', '(');
        set.put(']', '[');

        // for each character c in the string:
        for (char c : s.toCharArray()) {
            if (set.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == set.get(c)) stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
        
    }
}
