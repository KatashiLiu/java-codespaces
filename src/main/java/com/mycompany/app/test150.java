package com.mycompany.app;

import java.util.Deque;
import java.util.LinkedList;

public class test150 {
    /**
     * '+'、'-'、'*' 和 '/' 
        输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        输出：22
        解释：该算式转化为常见的中缀算术表达式为：
        ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5
        = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5
        = (0 + 17) + 5
        = 17 + 5
        = 22
     */
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")){
                stack.addLast(Integer.valueOf(token));
            }else{
                Integer y = stack.pollLast();
                Integer x = stack.pollLast();
                int z = 0;
                if(token.equals("+")){
                    z = x + y;
                }else if (token.equals("-")) {
                    z = x - y;
                }else if (token.equals("*")) {
                    z = x * y;
                }else if (token.equals("/")) {
                    z = x / y;
                }
                stack.addLast(z);
            }
        }
        return stack.pollLast();
    }
}
