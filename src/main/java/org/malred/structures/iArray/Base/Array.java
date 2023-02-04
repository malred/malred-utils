package org.malred.structures.iArray.Base;

/**
 * 普通数组对象
 *
 * @author malguy-wang sir
 * @create ---
 */
public abstract class Array {
    /**
     * 创建string类型的封装数组
     *
     * @param size
     * @return
     */
    public static Array StrArr(int size) {
        return new StringArray(size);
    }

    /**
     * 创建int类型的封装数组
     *
     * @param size
     * @return
     */
    public static Array IntArr(int size) {
        return new IntegerArray(size);
    }

    /**
     * 创建Object类型的封装数组
     *
     * @param size
     * @return
     */
    public static Array ObjArr(int size) {
        return new ObjectArray(size);
    }

    /**
     * 用数组来初始化封装数组的方法
     *
     * @param arr
     * @return
     */
    public abstract Array init(Object[] arr);

    /**
     * 获取size
     */
    public abstract int size();

    /**
     * 获取数组真实长度length
     */
    public abstract int length();

    /**
     * 设置对应索引的值
     *
     * @param index
     * @param value
     * @return
     */
    public abstract Array set(int index, Object value);

    /**
     * 获得对应索引的值
     *
     * @param index
     * @return
     */
    public abstract Object get(int index);

    /**
     * 获得内部保存的array 直接返回数组对象
     *
     * @return
     */
    public abstract Object[] getAll();

    /**
     * 获得内部保存的array 的tostring后的结果
     *
     * @return
     */
    public abstract String getAllToStr();


    /**
     * 将对应索引的值更改
     *
     * @param index
     * @param value
     * @return
     */
    public abstract Array update(int index, Object value);

    /**
     * 末尾添加新值(数组未满时才能用)
     *
     * @param index
     * @return
     */
    public abstract Object append(Object index);

    /**
     * 向数组中间插入新值
     */
    public abstract Object insert(int index, Object value);

    /**
     * 删除所有元素
     */
    public abstract Object clear();

    /**
     * 删除指定索引元素
     */
    public abstract Object remove(int index);

    /**
     * 扩容,默认扩容一倍
     */
    public abstract Object resize();

    /**
     * 扩容,用户指定扩容大小
     */
    public abstract Object resize(int size);
}
