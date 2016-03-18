package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sun.tools.hat.internal.util.Comparer;

public class Test01 {
	public static boolean isContain(String a, String b) {  
        boolean isContainStr = true;  
        char[] charA_array = a.toCharArray();  
        char[] charB_array = b.toCharArray();  
        HashMap<Character, Character> map = new HashMap();  
        for (int i = 0; i < charA_array.length; i++) {  
            map.put(charA_array[i], charA_array[i]);  
        }  
        int sizeA = map.keySet().size();  
        for (int i = 0; i < charB_array.length; i++) {  
            map.put(charB_array[i], charB_array[i]);  
        }  
        int sizeB = map.keySet().size();  
        if (sizeA < sizeB) {  
            isContainStr = false;  
        }  
        return isContainStr;  
    }  
  
    public static void main(String[] args) throws ParseException {  
//        String a = "abc", b = "abb";  
//        System.out.println(isContain(a, b));  
//        String c = "abc", d = "aaa";  
//        System.out.println(isContain(c, d));  
//        String e = "cba", f = "ea";  
//        System.out.println(isContain(e, f));  
    	
		
		Map map=new HashMap();
		System.out.println(map.isEmpty());
		
    	Date a=new Date();
    	System.out.println(a);
    }  
}
