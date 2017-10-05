package com.dreaouth.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String args[]) throws Exception {
        String s="jliu_1996@163.com";
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]*@[0-9A-Za-z.]+$");
        Matcher matcher=pattern.matcher(s);
        System.out.print(matcher.matches());
    }
}
