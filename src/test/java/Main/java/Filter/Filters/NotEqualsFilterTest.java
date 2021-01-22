package Main.java.Filter.Filters;

import Main.java.Filter.Filter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NotEqualsFilterTest {
    private final Map<String, String> user = new LinkedHashMap<>() {{
        put("firstname", "Joe");
        put("surname", "Blogs");
        put("role", "administrator");
        put("age", "35");
        put("car", "honda civic");
    }};
    private Filter true1 = new NotEqualsFilter("age","36");
    private Filter missing1 = new NotEqualsFilter("cup","large");
    private Filter false1 = new NotEqualsFilter("age","35");
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