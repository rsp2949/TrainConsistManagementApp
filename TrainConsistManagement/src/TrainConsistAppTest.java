import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class TrainConsistAppTest {

    private boolean binarySearch(String[] bogieIds, String key) {
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                return true;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    @Test
    public void testBinarySearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(arr, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(binarySearch(arr, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(arr, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(binarySearch(arr, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(binarySearch(arr, "BG205"));
    }
}