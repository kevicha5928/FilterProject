package Main.Filter.Filters;

import Main.Filter.Filter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AndFilterTest {
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


    @Test
    public void testTrue(){
        Filter combo1 = new AndFilter(true1, true2);
        assertTrue(combo1.match(user));
    }
    @Test
    public void testFalse(){
        Filter combo2 = new AndFilter(true1,false1);
        assertFalse(combo2.match(user));
    }

}