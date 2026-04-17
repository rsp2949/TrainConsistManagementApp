import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistAppTest {

    private boolean searchBogie(String[] bogieIds, String searchId) {
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

    @Test(expected = IllegalStateException.class)
    public void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        searchBogie(arr, "BG101");
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101", "BG205"};
        assertTrue(searchBogie(arr, "BG101"));
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(searchBogie(arr, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertFalse(searchBogie(arr, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(searchBogie(arr, "BG101"));
    }
}