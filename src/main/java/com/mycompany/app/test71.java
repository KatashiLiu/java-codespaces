package com.mycompany.app;

import java.util.ArrayDeque;
import java.util.Deque;

public class test71 {
    /**
     * 输入：path = "/a/./b/../../c/"
输出："/c"

     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if("..".equals(name)){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(name.length() > 0 && !".".equals(name)){
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}
