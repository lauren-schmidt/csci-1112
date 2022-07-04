import java.util.*;

public class QueueExample {

    public static void main (String[] argv)
    {
        // We'll use Java's LinkedList as our queue.
        ArrayList<String> taskQueue = new ArrayList<String>();

        // Add some strings.
        taskQueue.add ("Finish Module 8 Exercises...");
        taskQueue.add ("Study biology chapter");
        taskQueue.add ("Do calc homework problem set");
        taskQueue.add ("Shower");
        taskQueue.add ("Sleep?");
        
        // Now extract in "queue" order using the removeFirst() method in LinkedList.
        System.out.println (taskQueue.remove(0));
        System.out.println("List " + taskQueue);
        System.out.println (taskQueue.remove(0));
        System.out.println("List " + taskQueue);
        System.out.println (taskQueue.remove(0));
        System.out.println("List " + taskQueue);
        System.out.println (taskQueue.remove(0));
        System.out.println("List " + taskQueue);
        System.out.println (taskQueue.remove(0));
        System.out.println("List " + taskQueue);

        System.out.println ("=> Tasks remaining: " + taskQueue.size());
    }

}