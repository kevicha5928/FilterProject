package Main.java;

import Main.java.Filter.Filter;
import Main.java.Filter.Filters.EqualsFilter;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FilterBuilderTest {
    private final Map<String, String> user = new LinkedHashMap<>() {{
        put("firstname", "Joe");
        put("surname", "Blogs");
        put("role", "administrator");
        put("age", "35");
        put("car", "honda civic");
    }};
    private FilterBuilder myBuilder = new FilterBuilder();
    private String[] testCases = {"(firstname=bob||(firstname=Joe&&surname=Blogs))&&age>20&&role!chef&&car",
            "firstname=Joe&&(surname=Blogs||surname=Clogs)&&role=administrator&&age>20&&car!camry",
            "firstname=Joe&&surname=Blogs&&cups"
    };
    private boolean[] expected = {true,true, false};


    @Test
    public void testAllCases() {
        Filter filter;
        for(int i = 0; i<testCases.length;i++){
            filter = myBuilder.generateFilter(testCases[i]);
            assertEquals(filter.match(user),expected[i]);
        }
    }

    @Test
    public void testTrue(){
        Filter filter = myBuilder.generateFilter(testCases[0]);
        assertTrue(filter.match(user));
    }
    @Test
    public void testFalse(){
        Filter filter = myBuilder.generateFilter(testCases[2]);
        assertFalse(filter.match(user));
    }


}