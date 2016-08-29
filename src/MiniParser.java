import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/8/27.
 */
public class MiniParser {

    public class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger(){

        };

        // Constructor initializes a single integer.
        public NestedInteger(int value){

        };

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public  boolean isInteger(){
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public  Integer getInteger(){
            return new Integer(0);
        };

        // Set this NestedInteger to hold a single integer.
        public  void setInteger(int value){

        };

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public  void add(NestedInteger ni){

        };

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList(){
            return new ArrayList<NestedInteger>();
        }
    }

    public NestedInteger deserialize(String s) {
        if (s == null) {
            return null;
        }

        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }


        NestedInteger nestedInteger = null;
        Stack<NestedInteger> stack = new Stack<NestedInteger>();

        for (String elem : s.split(",")) {
            String elem1 = elem.replace("[", "");
            for (int i = 0; i < elem.length() - elem1.length(); i++) {
                stack.push(new NestedInteger());
            }
            String elem2 = elem1.replace("]", "");
            if (elem2.length() > 0) {
                int value = Integer.valueOf(elem2);
                stack.peek().add(new NestedInteger(value));
            }
            for (int i = 0; i < elem1.length() - elem2.length(); i++) {
                nestedInteger = stack.pop();
                if (!stack.isEmpty()) {
                    stack.peek().add(nestedInteger);
                }
            }
        }

        return nestedInteger;
    }
}
