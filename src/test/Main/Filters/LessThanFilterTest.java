package Main.Filter.Filters;

import Main.Filter.Filter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LessThanFilterTest {
    private final Map<String, String> user = new LinkedHashMap<>() {{
        put("firstname", "Joe");
        put("surname", "Blogs");
        put("role", "administrator");
        put("age", "35");
        put("car", "honda civic");
    }};
    private Filter true1 = new LessThanFilter("age","50");
    private Filter missing1 = new LessThanFilter("cup","large");
    private Filter false1 = new LessThanFilter("age","20");
    @Test
    public void testTrue(){
        assertTrue(true1.match(user));
    }
    @Test
    public void testFalse(){
        assertFalse(false1.match(user));
    }
    @Test
    public void testMissing(){
        assertFalse(missing1.match(user));
    }

}