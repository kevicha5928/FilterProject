package Main.java.Filter.Filters;

import Main.java.Filter.Filter;

import java.util.Map;

public class AndFilter extends Filter {

    public AndFilter(Filter filter1, Filter filter2){
        this.filter1 = filter1;
        this.filter2 = filter2;
    }

    @Override
    public boolean match(Map<String, String> user) {
        return filter1.match(user)&&filter2.match(user);
    }

    @Override
    public String toString() {
        return "("+filter1.toString()+"&&"+filter2.toString()+")";
    }
}
