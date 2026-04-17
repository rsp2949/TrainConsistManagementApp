import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistAppTest {

    private boolean linearSearch(String[] bogieIds, String searchId) {
        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testSearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(linearSearch(arr, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(arr, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(linearSearch(arr, "BG550"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(linearSearch(arr, "BG101"));
    }
}