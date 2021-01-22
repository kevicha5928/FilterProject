package Main;

import Main.Filter.Filter;
import Main.Filter.Filters.AndFilter;
import Main.Filter.Filters.EqualsFilter;

import java.util.LinkedHashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        Map<String, String> user = new LinkedHashMap<>();
        user.put("firstname", "Joe");
        user.put("surname","Blogs");
        user.put("role","administrator");
        user.put("age","35");

        Filter ageFilter = new EqualsFilter("age","35");
        System.out.println(ageFilter);
        boolean result = ageFilter.match(user);
        System.out.println(result);
        Filter surnameFilter = new EqualsFilter("surname", "Blogs");
        System.out.println(surnameFilter);
        result = surnameFilter.match(user);
        System.out.println(result);
        Filter nameFilter = new EqualsFilter("firstname","Joe");
        System.out.println(nameFilter);
        result = nameFilter.match(user);
        System.out.println(result);
        Filter comboFilter1 = new AndFilter(nameFilter,surnameFilter);
        System.out.println(comboFilter1);
        result = comboFilter1.match(user);
        System.out.println(result);


        String example = "firstname=bob||surname=Blogs&&age=35";
        FilterBuilder myBuilder = new FilterBuilder();
        Filter filter = myBuilder.generateFilter(example);
        System.out.println(filter);
        System.out.println("-------------");
        System.out.println(filter.match(user));

    }
}
