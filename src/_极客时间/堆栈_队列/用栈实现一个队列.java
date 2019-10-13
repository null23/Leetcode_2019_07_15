package _极客时间.堆栈_队列;

import java.util.Stack;

/**
 * leetcodee 232
 */
public class 用栈实现一个队列 {

    /**
     * 重点是：两个栈，一个输入栈，一个输出栈
     */
    public static class MyQueue{
        Stack inputStack = new Stack();
        Stack outputStack = new Stack();
        public void push(Object obj){
            inputStack.push(obj);
        }

        /**
         *  1.如果输出栈还有值，那就pop输出栈的元素
         *  2.如果输出栈为空，那就把输入栈的元素倒腾到输出栈里，然后重新输出
         */
        public Object pop(){
            if(!outputStack.empty()){
                return outputStack.pop();
            }else{
                while(!inputStack.empty()){
                    outputStack.push(inputStack.pop());
                }
                return outputStack.pop();
            }
        }
    }

}
