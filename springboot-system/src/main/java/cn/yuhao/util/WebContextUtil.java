package cn.yuhao.util;

import cn.yuhao.pojo.vo.UserToken;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class WebContextUtil {
 
 
    //本地线程缓存token
    private static ThreadLocal<String> local = new ThreadLocal<>();
 
 
    /**
     * 设置token信息
     * @param content
     */
    public static void setUserToken(String content){
        removeUserToken();
        local.set(content);
    }
 
 
    /**
     * 获取token信息
     * @return
     */
    public static UserToken getUserToken(){
        if(local.get() != null){
           Gson gson =  new Gson();
           UserToken userToken = gson.fromJson(local.get(),UserToken.class);
//            UserToken userToken = JSONObject.parseObject(local.get() , UserToken.class);
            return userToken;
        }
        return null;
    }
 
 
    /**
     * 移除token信息
     * @return
     */
    public static void removeUserToken(){
        if(local.get() != null){
            local.remove();
        }
    }
}