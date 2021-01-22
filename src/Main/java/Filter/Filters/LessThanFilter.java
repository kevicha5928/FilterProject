package Main.java.Filter.Filters;

import Main.java.Filter.Filter;

import java.util.Map;

public class LessThanFilter extends Filter {
    public LessThanFilter(String property, String value){
        this.property = property;
        this.value = value;
        this.filterType="<";
    }
    @Override
    public boolean match(Map<String, String> user) {
        boolean result = false;
        if (user.containsKey(this.property))
            if (isNumeric(value))
                result = Double.parseDouble(user.get(property))<Double.parseDouble(value);
            else
                System.out.println("Not a numerical value");
        return result;
    }
}
