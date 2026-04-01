import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - TrainConsistApp
 * ============================================================
 *
 * Use Case 1: Initialize Train and Display Consist Summary
 *
 * @author Praveen R S
 * @version 1.0
 */

public class TrainConsistApp {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("======================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("======================================\n");

        // Dynamic list to store bogies
        List<String> trainConsist = new ArrayList<>();

        // Display initial state
        System.out.println("Train initialized successfully...");
        System.out.println("Initial Bogie Count : " + trainConsist.size());
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}