package util;

import org.apache.maven.shared.utils.StringUtils;

public class U {
    public static void print(String s){
        System.out.println(s);
    }
    public static String lpad(String s, Integer size, String pad){
        return StringUtils.leftPad(s,size,pad);
    }
    public static String rpad(String s, Integer size, String pad){
        return StringUtils.rightPad(s,size,pad);
    }
}
