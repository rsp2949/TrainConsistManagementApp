import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrainConsistAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90)
        );
    }

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 100)
                .toList();

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<Bogie> result = getBogies().stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());

        assertEquals(4, result.size());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getBogies());

        List<Bogie> filtered = original.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(4, original.size()); // original unchanged
    }
}