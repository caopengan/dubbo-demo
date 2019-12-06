package com.dubbo.providerdemo.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {

    public static Map<String,String> ele = new HashMap<String,String>();

    public static List<String> letterCombinations(String digits){
        if(digits == null || digits.equals("")){
            return new ArrayList<String>();
        }
        if(digits.contains("0")||digits.contains("1")){
            return new ArrayList<String>();
        }
        ele.put("2","abc");
        ele.put("3","def");
        ele.put("4","ghi");
        ele.put("5","jkl");
        ele.put("6","mno");
        ele.put("7","pqrs");
        ele.put("8","tuv");
        ele.put("9","wxyz");
        String firstStr = ele.get(digits.charAt(0)+"");
        List<String> firstList = new ArrayList<String>();
        for(char c:firstStr.toCharArray()){
            firstList.add(c+"");
        }
        for(int i=1;i<digits.length();i++){
            String nextStr = ele.get(digits.charAt(i)+"");
            firstList = addNextStr(firstList,nextStr);
        }
        return firstList;
    }

    public static List<String> addNextStr(List<String> resList, String str) {
        List<String> newList = new ArrayList<>();
        for(String s : resList) {
            for(char nextCh : str.toCharArray()) {
                newList.add(s+nextCh);
            }
        }
        return newList;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

}
