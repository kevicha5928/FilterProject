package Main.Filter.Filters;

import Main.Filter.Filter;

import java.util.Map;

public class EqualsFilter extends Filter {
    public EqualsFilter(String property, String value){
        this.property = property;
        this.value = value;
        this.filterType = "=";
    }


    @Override
    public boolean match(Map<String, String> user) {
        boolean result = false;
        if (user.containsKey(this.property))
            if (isNumeric(value))
                result = Double.parseDouble(user.get(property))==Double.parseDouble(value);
            else
                result = user.get(property).equals(value);
        return result;
    }
}
