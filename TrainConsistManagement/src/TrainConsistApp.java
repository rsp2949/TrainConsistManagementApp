import java.util.*;

public class TrainConsistApp {
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" UC5 - Preserve Insertion Order ");
        System.out.println("==================================\n");

        // LinkedHashSet
        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Duplicate
        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nUC5 completed...");
    }
}