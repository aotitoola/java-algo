package b.heapQueueStack;

import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    private static final Map<Character, Character> map = Map.of('(', ')', '{','}','[',']');
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // if it is an opening bracket or parenthesis
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                // edge case, check if stack is empty
                if (stack.isEmpty()){
                    // then it is invalid
                    return false;
                }
                // pop out the open bracket and assign to variable
                char open = stack.pop();

                // check if we have a bad match
                if (map.get(open) != c) {
                    return false;
                }
            }
        }

        // there might be at least 1 stack that is not closed
        return stack.isEmpty();
    }

}
