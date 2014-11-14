import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        stack.push(x);

        if (x < min) {
            min = x;
        }
    }

    public void pop() {

        if (stack.empty()) {
            return;
        }

        int x = stack.pop();

        if (x == min) {
            min = Integer.MAX_VALUE;
            if (!stack.empty()) {
                for (int i : stack) {
                    if (i < min) {
                        min = i;
                    }
                }
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String [ ] args) {
        MinStack m = new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}
