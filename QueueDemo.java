import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args){
        Queue<String> stringQueue = new LinkedList<String>();
        stringQueue.add("One");
        stringQueue.add("Two");
        System.out.println(stringQueue.peek());
        System.out.println(stringQueue.remove());
        System.out.println(stringQueue.remove());
    }
}