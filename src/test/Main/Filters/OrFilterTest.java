package Main.Filter.Filters;

import Main.Filter.Filter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrFilterTest {
    private final Map<String, String> user = new LinkedHashMap<>() {{
        put("firstname", "Joe");
        put("surname", "Blogs");
        put("role", "administrator");
        put("age", "35");
        put("car", "honda civic");
    }};
    private Filter true1 = new GreaterThanFilter("age","20");
    private Filter true2 = new LessThanFilter("age","50");
    private Filter false1 = new ExistFilter("cup");
    private Filter false2 = new EqualsFilter("firstname","bob");

    @Test
    public void testTrue(){
        Filter combo1 = new OrFilter(true1, true2);
        Filter combo2 = new OrFilter(true1,false1);
        assertTrue(combo1.match(user));
        assertTrue(combo2.match(user));
    }
    @Test
    public void testFalse(){
        Filter combo3 = new OrFilter(false2,false1);
        assertFalse(combo3.match(user));
    }

}