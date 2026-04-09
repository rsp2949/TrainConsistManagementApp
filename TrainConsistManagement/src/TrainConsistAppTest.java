import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TrainConsistAppTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getBogies() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Type" + i, i % 100));
        }
        return list;
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : getBogies()) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : getBogies()) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long end = System.nanoTime();

        assertTrue(end - start > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Type" + i, i % 100));
        }

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertNotNull(result);
    }
}