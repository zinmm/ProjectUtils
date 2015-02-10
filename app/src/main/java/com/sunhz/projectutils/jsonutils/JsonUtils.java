/**
 * GSON (https://code.google.com/p/google-gson/)
 *
 * @link https://code.google.com/p/google-gson/
 * @license http://www.apache.org/licenses/LICENSE-2.0
 * @package com.google.gson
 */
package com.sunhz.projectutils.jsonutils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * 使用Gson,解析
 * Created by Spencer on 15/2/3.
 */
public class JsonUtils {
    private static JsonUtils jsonUtils;
    private static Gson gson;

    private JsonUtils() {

    }

    public synchronized static JsonUtils getInstance() {
        if (jsonUtils == null || gson == null) {
            jsonUtils = new JsonUtils();
            gson = new Gson();
        }
        return jsonUtils;
    }

    /**
     * 对象 转换成 string
     *
     * @param t 待转换对象
     * @return json
     */
    public <T> String objectToJson(T t) {
        return gson.toJson(t);
    }

    /**
     * string 转换成 对象
     *
     * @param json  json内容
     * @param clazz 需要转换成的类型
     * @return object
     */
    public <T> T jsonToObject(String json, Class clazz) {
        return (T) gson.fromJson(json, clazz);
    }

    public <T> List<T> jsonToObjectList(String json) {
        return gson.fromJson(json,
                new TypeToken<List<T>>() {
                }.getType());
    }
}
