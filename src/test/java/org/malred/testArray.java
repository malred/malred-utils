package org.malred;

import org.junit.Test;
import org.malred.structures.iArray.Base.Array;

/**
 * 测试数组
 *
 * @author malguy-wang sir
 * @create ---
 */
public class testArray {
    @Test
    public void t1() {
        // string
        Array arr = Array.StrArr(5);
        System.out.println(arr.init(new String[]{"a", "b", "c"}));
        System.out.println(arr.set(0, "1"));
        System.out.println(arr.get(0));
        System.out.println(arr.update(0, "2"));
        System.out.println(arr.append("op"));
        System.out.println("当前数组长度: " + arr.length());
        System.out.println(arr.append("op"));
        System.out.println(arr.resize());
        System.out.println(arr.resize(20));
        System.out.println(arr.remove(0));
        System.out.println(arr.getAll()[0]);
        System.out.println(arr.getAllToStr());
        System.out.println(arr.clear());
    }

    @Test
    public void t2() {
        // int
        Array arr = Array.IntArr(5);
        // int没办法转object,所以用 Integer
        System.out.println(arr.init(new Integer[]{1, 2, 3, 4}));
        System.out.println(arr.set(0, 3));
        System.out.println(arr.get(0));
        System.out.println(arr.update(0, 4));
        System.out.println(arr.append(5));
        System.out.println(arr.append(6));
        System.out.println("当前数组长度: " + arr.length());
        System.out.println(arr.resize());
        System.out.println(arr.resize(20));
        System.out.println(arr.remove(0));
        System.out.println(arr.getAll()[0]);
        System.out.println(arr.getAllToStr());
        System.out.println(arr.clear());
    }
}
