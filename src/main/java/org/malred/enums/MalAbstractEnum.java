package org.malred.enums;

import java.util.Map;

/**
 * 抽象的枚举类接口
 *
 * @author malguy-wang sir
 * @create ---
 */
public interface MalAbstractEnum {
    /**
     * 在初始化时存放当前枚举类实例的属性名和属性值
     *
     * @return
     */
    public Map<String, Object> getAllStatus();
}
