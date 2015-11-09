import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {
    Queue<Integer> q = new LinkedList<Integer>();


    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        recurPop();
    }

    public int recurPop() {
        int e = q.poll();
        int last;
        if (q.isEmpty()) {
            return e;
        } else {
            last = recurPop();
        }
        q.add(e);

        return last;
    }

    // Get the top element.
    public int top() {
        int e = recurPop();
        q.add(e);

        return e;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String [ ] args) {
        ImplementStackusingQueues s = new ImplementStackusingQueues();

        s.push(1);
        s.push(2);
        System.out.println(s.top());
    }
}
