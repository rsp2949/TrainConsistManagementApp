import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistAppTest {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String name;
        int capacity;

        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    public void testException_ValidCapacityCreation() throws Exception {
        PassengerBogie b = new PassengerBogie("Sleeper", 72);
        assertEquals(72, b.capacity);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_NegativeCapacityThrowsException() throws Exception {
        new PassengerBogie("Sleeper", -10);
    }

    @Test(expected = InvalidCapacityException.class)
    public void testException_ZeroCapacityThrowsException() throws Exception {
        new PassengerBogie("Sleeper", 0);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        try {
            new PassengerBogie("Sleeper", 0);
        } catch (InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws Exception {
        PassengerBogie b = new PassengerBogie("AC Chair", 56);
        assertEquals("AC Chair", b.name);
        assertEquals(56, b.capacity);
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws Exception {
        PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
        PassengerBogie b2 = new PassengerBogie("First Class", 24);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}