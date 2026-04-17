public class TrainConsistApp {

    public static boolean searchBogie(String[] bogieIds, String searchId) {
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC20 - Exception Handling During Search ");
        System.out.println("========================================\n");

        String[] bogieIds = {};
        String searchId = "BG101";

        boolean found = searchBogie(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie Found");
        } else {
            System.out.println("Bogie Not Found");
        }

        System.out.println("\nUC20 execution completed...");
    }
}