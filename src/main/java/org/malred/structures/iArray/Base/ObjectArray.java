package org.malred.structures.iArray.Base;

import java.util.Arrays;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class ObjectArray extends Array {
    Object[] array;
    int length = 0;

    int size = 0;

    public ObjectArray(int size) {
        if (size <= 0) {
            return;
        }
        this.size = size;
        this.array = new Object[size];
        this.length = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int length() {
        return this.length;
    }

    public Array len() {
        length = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                length += 1;
            }
        }
        return this;
    }

    @Override
    public Array init(Object[] arr) {
        for (int i = 0; i <= array.length - 1 && i <= arr.length - 1; i++) {
            array[i] = arr[i];
        }
        len();// 重新计算真实长度
        return this;
    }

    @Override
    public Array set(int index, Object value) {
        if (index > size - 1) {
            return this;
        }
        array[index] = value;
        return this;
    }

    @Override
    public Object get(int index) {
        if (index > size - 1) {
            return this;
        }
        return this.array[index];
    }

    @Override
    public Object[] getAll() {
        return this.array;
    }

    @Override
    public String getAllToStr() {
        return Arrays.toString(array);
    }

    @Override
    public Array update(int index, Object value) {
        if (index > size - 1) {
            return this;
        }
        this.set(index, value);
        return this;
    }

    @Override
    public Object append(Object value) {
        // 如果数组已经满了
        if (length == size) {
            // 覆盖最后一个元素
            this.set(length, value);
            len(); // 重新计算真实长度
            return this;
        }
        this.set(length, value);
        len(); // 重新计算真实长度
        return this;
    }

    @Override
    public Object insert(int index, Object value) {
        for (int i = array.length - 1; i >= index - 1; i--) {
            // 有值才移动
            if (array[i] != null) {
                array[i + 1] = array[i];
            }
        }
        array[index] = value;
        len(); // 重新计算数组真实长度
        return this;
    }

    @Override
    public Object clear() {
        this.array = null;
        this.length = this.size = 0;
        return this;
    }

    @Override
    public Object remove(int index) {
        for (int i = index; i <= length - 1; i++) {
            if (i < length - 1) {
                array[i] = array[i + 1];
            } else {
                // 最后一位要清除,因为移动了前面,最后一位没有移动
                array[i] = null;
            }
        }
        len();
        return this;
    }

    @Override
    public Object resize() {
        resize(0);
        return this;
    }

    @Override
    public Object resize(int size) {
        Object[] newArray;
        if (size <= this.size) {
            this.size *= 2;
            // 默认扩容一倍
            newArray = new Object[this.size];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            return this;
        }
        this.size = size;
        newArray = new Object[size];
        // 拷贝内容
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
        return this;
    }

    @Override
    public String toString() {
        return "ObjectArray{" +
                "array=" + Arrays.toString(array) +
                ", length=" + length +
                ", size=" + size +
                '}';
    }
}
