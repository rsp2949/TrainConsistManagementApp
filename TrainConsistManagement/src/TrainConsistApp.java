import java.util.*;

public class TrainConsistApp {
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("==================================\n");

        // Create LinkedList
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // Insert at position
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car:");
        System.out.println(trainConsist);

        // Remove first and last
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter removing first and last:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 completed...");
    }
}