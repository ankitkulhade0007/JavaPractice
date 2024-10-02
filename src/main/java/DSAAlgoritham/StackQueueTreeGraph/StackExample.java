package DSAAlgoritham.StackQueueTreeGraph;

import java.util.Stack;

public class StackExample {


    public static void main(String[] args) {
        String s = "{()}[]";
        if (parenthesisChecker(s))
            System.out.println("true");
        else
            System.out.println("false");

        String reverse = reverseAString("Ankit");
        System.out.println(reverse);
    }

    static boolean parenthesisChecker(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && (
                        stack.peek() == '(' && s.charAt(i) == ')' ||
                                stack.peek() == '{' && s.charAt(i) == '}' ||
                                stack.peek() == '[' && s.charAt(i) == ']'
                )) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static String reverseAString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
