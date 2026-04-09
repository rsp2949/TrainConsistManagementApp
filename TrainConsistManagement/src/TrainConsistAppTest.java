import org.junit.Test;
import static org.junit.Assert.*;

public class TrainConsistAppTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
            } finally {
            }
        }
    }

    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie g = new GoodsBogie("Cylindrical");
        g.assignCargo("Petroleum");
        assertEquals("Petroleum", g.cargo);
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie g = new GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");
        assertNull(g.cargo);
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie g = new GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");
        assertNull(g.cargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie g1 = new GoodsBogie("Rectangular");
        g1.assignCargo("Petroleum");

        GoodsBogie g2 = new GoodsBogie("Cylindrical");
        g2.assignCargo("Coal");

        assertEquals("Coal", g2.cargo);
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie g = new GoodsBogie("Rectangular");
        g.assignCargo("Petroleum");
        assertTrue(true);
    }
}