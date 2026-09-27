// Exercise 4.2 — Build a Generic Box<T>
//
// TODO 1: Define a generic class Box<T> with:
//         - a private field of type T
//         - set(T value)
//         - get() returning T
//         - isEmpty() returning true if the content is null
//
// TODO 2: In main, create a Box<String> and a Box<Integer>, and exercise all the methods.

class Box<T> {
    // TODO 1: implement
    private T content;
    public void setContent(T value) {
        content = value;
    }
    public T getContent() {
        return content;
    }
    public boolean isEmpty() {
        if(content instanceof String) {
            if(content == "" || content == null) {
                return true;
            }
        }
        return (content == null);
    }
}



public class Exercise4_2_Box {
    public static void main(String[] args) {
        // TODO 2: create Box<String> and Box<Integer>, use set/get/isEmpty
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.setContent(10);
        stringBox.setContent("");

        System.out.println(integerBox.getContent());
        System.out.println(stringBox.getContent());

        System.out.println(integerBox.isEmpty());
        System.out.println(stringBox.isEmpty());
    }
}
