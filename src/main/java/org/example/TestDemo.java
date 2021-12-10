package org.example;

import org.junit.Test;

import java.util.Hashtable;

/**
 * @author rocker
 * @date 2021/12/10 17:54
 */
public class TestDemo {

    @Test
    public void test(){
        Object s = null;
        Hashtable s1 = (Hashtable) s;
        if(s1 == null){
            System.out.println("222");
        }else{
            System.out.println("111");
        }
    }

}
