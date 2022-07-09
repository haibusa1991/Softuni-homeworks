package lecture03Inheritance.L05StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;
    private ArrayDeque<String> stack = new ArrayDeque<>();

    public void push(String item) {
        stack.push(item);
    }

    public String pop() {
        return stack.pop();
    }

    public String peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
