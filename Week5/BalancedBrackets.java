public class BalancedBrackets {
    private Character checkPairBrackets(Character x) {
        switch (x) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return ' ';
        }
    }

    public String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()
                    && s.charAt(i) == checkPairBrackets(stack.peek())) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
