package cn.eviao.k8slearn.usercenter.model;

import java.io.Serializable;
import java.util.HashMap;

public class Result extends HashMap<String, Object> implements Serializable {
    public static Result create(String message) {
        return new Result() {{
            put("message", message);
        }};
    }

    public static Result create(String message, Object data) {
        return new Result() {{
            put("message", message);
            put("data", data);
        }};
    }
}
