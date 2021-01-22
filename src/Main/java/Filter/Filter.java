package Main.java.Filter;

import java.util.Map;

public class Filter {
    protected String property;
    protected String value;
    protected String filterType;
//    protected Filter[] filters;
    protected Filter filter1;
    protected Filter filter2;
    public Filter(String property, String value){
        this.property = property;
        this.value = value;
    }
    public Filter(Filter filter1, Filter filter2){
        this.filter1 = filter1;
        this.filter2 = filter2;
    }
    public Filter(){
        this.property = null;
        this.value = null;
    }
    public boolean match(Map<String, String> user){
        return true;
    }
    protected boolean isNumeric(String str){
        try{
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public String toString(){
        return property+filterType+value;
    }
}
