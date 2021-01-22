# FilterProject
 
Assumptions: 
1. all keys/values in the maps are strings
2. If a property is missing, the filter will return false
3. filters can be programmatically constructed using the filterBuilder class.
Although, there are some constraints on how the user supplied string representation
will be processed.

    * conditions that need to be considered together must be enclosed with a parentheses
        * ie (name=bob||name=carl)&&(age<50&&age>20)
    * if no parentheses are provided then, method will assume groupings from left to right
        * ie firstname=bob||surname=Blogs&&age=35 -> 
            * (firstname=bob||(surname=Blogs&&age=35))
