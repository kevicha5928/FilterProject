package Main;

import Main.Filter.Filter;
import Main.Filter.Filters.*;


public class FilterBuilder {
    /**
     * This method recursively generates a chain of filters based on
     * a string input from the user.
     * conditions that need to be considered together must be enclosed with a parentheses
     * ie (name=bob||name=carl)&&(age<50&&age>20)
     * if not parentheses are provided then, method will assume groupings from left to right
     * ie firstname=bob||surname=Blogs&&age=35 -> (firstname=bob||(surname=Blogs&&age=35))
     *
     * Please note this generator may not cover all cases. this was all I could come up with
     * given the time I was able to devote to this assignment
     *
     * @param filterString this is the string representation of the filter
     * @return Filter This is the generated filter based on user input
     */

    public Filter generateFilter(String filterString){
//        base case: there should only be one filter remaining
        if (!filterString.contains("(")&&!filterString.contains("&&")&&!filterString.contains("||")){
            return chooseFilter(filterString);
        }
        Filter left;
        Filter right = null;

        String comparator = null;

        String leftStr;
        String rightStr = null;

//        parse string based on whether or not a grouping exists
        if (filterString.charAt(0)=='('){
            int temp = findEndOfParentheses((filterString));
            leftStr = filterString.substring(1,temp-1);
            if (temp<filterString.length()-5){
                rightStr = filterString.substring(temp+2);
                comparator = filterString.substring(temp,temp+2);
            }
        }
        else {
            String[] splitStr = filterString.split("&&|\\|\\|",2);
            leftStr = splitStr[0];
            if (splitStr.length>1){
                rightStr = splitStr[1];
                comparator = filterString.substring(splitStr[0].length(),splitStr[0].length()+2);
            }
        }
        left = generateFilter(leftStr);
        if (rightStr!=null){
            right = generateFilter(rightStr);
        }


        Filter resultFilter = null;
        if (rightStr == null){
            resultFilter = left;
        }
        else if (comparator.equals("||")){
            resultFilter = new OrFilter(left,right);
        }
        else if (comparator.equals("&&")) {
            resultFilter = new AndFilter(left, right);
        }
        return resultFilter;
    }

    /**
     * This function locates the end index of a parentheses group
     * @param item the String to be parsed for parentheses
     * @return the index+1 of the last parentheses in the group
     */
    private static int findEndOfParentheses(String item){
        int stack = 0;
        for (int i = 0; i<item.length();i++){
            if (item.charAt(i)=='(')
                stack+=1;
            else if (item.charAt(i)==')')
                stack-=1;
            if (stack==0){
                return i+1;
            }
        }
        return -1;

    }

    /**
     * this method is used to choose which filter matches a given string input representation
     * of a filter
     * ie age>20 -> GreaterThanFilter("age","20")
     *
     * @param strFilter string filter rep to be parsed
     * @return Filter the generated filter
     */
    private Filter chooseFilter(String strFilter) {
        String[] strArr = strFilter.split("=|<|>|!");
        if (strArr.length==1){
            return new ExistFilter(strArr[0]);
        }
        String property = strArr[0];
        String value = strArr[1];
        int compLoc = property.length();
        String comparator = strFilter.substring(compLoc,compLoc+1);
        Filter outputFilter = null;
        switch (comparator){
            case "=":
                outputFilter = new EqualsFilter(property,value);
                break;
            case "<":
                outputFilter = new LessThanFilter(property,value);
                break;
            case ">":
                outputFilter = new GreaterThanFilter(property,value);
                break;
            case "!":
                outputFilter = new NotEqualsFilter(property,value);
                break;
        }
        return outputFilter;

    }
}
