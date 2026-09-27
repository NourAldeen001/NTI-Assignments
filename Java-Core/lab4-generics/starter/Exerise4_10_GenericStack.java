import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Exercise 4.10 — Capstone: A Type-Safe Generic Stack
//
// TODO 1: Implement Stack<T> backed internally by an ArrayList<T>, with:
//         push(T item), pop(), peek(), isEmpty()
//         pop()/peek() should throw NoSuchElementException if the stack is empty.
//
// TODO 2: Implement <T extends Comparable<T>> T maxInStack(Stack<T> stack)
//         that empties the stack while finding the maximum element.
//
// TODO 3: Test everything with a Stack<Integer>.

class Stack<T> {
    // TODO 1: implement using an internal ArrayList<T>
    private ArrayList<T> content;

    Stack() {
        content = new ArrayList<>();
    }

    public void push(T item) {
        content.add(item);
    }

    public T pop() {
        if(!content.isEmpty()) {
            return content.remove(content.size()-1);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public T peek() {
        if(!content.isEmpty()) {
            return content.get(content.size()-1);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEmpty() {
        return content.isEmpty();
    }


}

public class Exerise4_10_GenericStack {

    // TODO 2: implement maxInStack using a bounded type parameter
    public static <T extends Comparable<T>> T maxInStack(Stack<T> stack) {
        Stack<T> s = new Stack<>();
        T max = stack.pop();
        while(!stack.isEmpty()) {
            T current = stack.pop();
            s.push(current);
            if(current.compareTo(max) > 0) {
                max = current;

            }
        }
        return max;
    }

    public static void main(String[] args) {
    // TODO 3: push several integers, then find and print the max

        Stack<Integer> stack = new Stack<>();
        stack.push(50);
        stack.push(30);
        stack.push(10);

        System.out.println(Exerise4_10_GenericStack.maxInStack(stack));
    }
}


