package org.malred;

import org.junit.Test;
import org.malred.enums.MalHttpStatus;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class testEnum {
    /**
     * 测试状态枚举
     */
    @Test
    public void t1() {
        MalHttpStatus success = MalHttpStatus.SUCCESS;
//        Map vals = success.getAllStatus();
        System.out.println(success.Code() + "\n" + success.Status());
    }
}
