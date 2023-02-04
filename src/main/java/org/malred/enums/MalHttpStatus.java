package org.malred.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举返回给前端的状态码
 *
 * @author malguy-wang sir
 * @create ---
 */
public enum MalHttpStatus implements MalAbstractEnum {
    SUCCESS(200, "成功", null),
    NOTAUTH(403, "未授权", null),
    ERROR(500, "内部错误", null);
    /**
     * 状态码
     */
    private final int code;
    /**
     * 状态信息
     */
    private final String status;

    /**
     * 存放属性名:值的map
     *
     * @return
     */
    public Map<String, Object> vals;

    /**
     * 直接返回map里存的code
     *
     * @return
     */
    public Object Code() {
        return vals.get("code");
    }

    /**
     * 直接返回map里存的status
     *
     * @return
     */
    public Object Status() {
        return vals.get("status");
    }

    MalHttpStatus(int code, String status, Map map) {
        this.code = code;
        this.status = status;
        this.vals = this.getAllStatus(); // 数据放入map
    }

    @Override
    public String toString() {
        return "MalHttpStatus{" +
                "code=" + code +
                ", status='" + status + '\'' +
                '}';
    }

    /**
     * 返回map,存放的是属性名和属性值
     *
     * @return
     */
    @Override
    public Map<String, Object> getAllStatus() {
        HashMap<String, Object> values = new HashMap<>();
        values.put("code", this.code);
        values.put("status", this.status);
        return values;
    }
}
