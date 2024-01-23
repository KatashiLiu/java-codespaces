package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class test452 {
    /**
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：气球可以用2支箭来爆破:
-在x = 6处射出箭，击破气球[2,8]和[1,6]。
-在x = 11处发射箭，击破气球[10,16]和[7,12]。
     */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        // 计算交集
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] compare1, int[] compare2){
                if(compare1[0]>compare2[0]){
                    return 1;
                }else if(compare1[0]<compare2[0]){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        int num = 1;
        int right = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(right<points[i][0]){
                num++;
                right = points[i][1];
            }else{
                right = Math.min(right, points[i][1]);
            }
        }
        return num;
        // ArrayList<int[]> list = new ArrayList<>();
        // for (int i = 0; i < points.length; i++) {
        //     int L = points[i][0], R = points[i][1];
        //     if(i==0 || list.get(list.size()-1)[1]<L){
        //         list.add(new int[]{L,R});
        //     }else{
        //         list.get(list.size()-1)[1] = Math.min(list.get(list.size()-1)[1], L); 
        //     }
        // }
        // return list.size();
    }
}