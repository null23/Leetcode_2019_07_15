package _极客时间.堆栈_队列;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 判断字符串是否有效 {

    public boolean isValid(String str){
        Map<String, String> parentMap = new HashMap<>();
        parentMap.put(")","(");
        parentMap.put("}","{");
        parentMap.put("]","[");

        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(!parentMap.containsKey(str.charAt(i)) && !stack.pop().equals(str.charAt(i))){
                return false;
            }else{
                stack.push(String.valueOf(str.charAt(i)));
            }
        }
        if(stack.empty()){
            return false;
        }
        return true;
    }
}
