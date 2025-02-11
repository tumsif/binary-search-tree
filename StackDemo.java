import java.util.Stack;

public class StackDemo {
    public static void main(String[] args){
        Stack<String> stackString = new Stack<>();
        stackString.push("One");
        stackString.push("Two");
        stackString.push("Three");

        System.out.println(stackString.pop());
        System.out.println(stackString.pop());
    }
}