package simple;

import util.U;

public class XImpl implements X<String,Integer>{


    @Override
    public Integer f0(String s) {
        return s.length();
    }

    @Override
    public void f1(String s, Integer i) {
        U.print(U.lpad(s,i,"#"));
    }

    @Override
    public Integer f2(String s, Integer i) {
        return s.length() * i;
    }

    @Override
    public String f3(String s, Integer i) {
        Integer integer1 = s.length() * i;
        return integer1.toString();
    }

    @Override
    public X<String, Integer> f4(String s, Integer i) {
        U.print(f0(s).toString());
        f1(s,i);
        U.print(f2(s,i).toString());
        U.print(f3(s,i));
        return new XImpl();
    }
}
