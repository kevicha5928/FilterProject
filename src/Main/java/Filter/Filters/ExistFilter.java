package Main.java.Filter.Filters;

import Main.java.Filter.Filter;

import java.util.Map;

public class ExistFilter extends Filter {

    public ExistFilter(String property){
        this.property = property;
    }
    @Override
    public boolean match(Map<String, String> user) {
        return (user!=null && user.containsKey(property));
    }
}
