import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

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
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    @Test
    public void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(3, grouped.keySet().size());
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        Map<String, List<Bogie>> grouped =
                empty.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> grouped =
                list.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.size());
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> grouped =
                getBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getBogies());

        original.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(5, original.size());
    }
}