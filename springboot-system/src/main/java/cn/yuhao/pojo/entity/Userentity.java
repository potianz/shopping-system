package cn.yuhao.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */
@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user")
public class Userentity implements Serializable {
    /**
     * 主键
     */
    private String rid;
    /**
     * 用户名
     */
    @SerializedName("user_name")
    private String userName;

    /**
     * 用户密码
     */
    @SerializedName("user_password")
    private String userPassword;
    /**
     * 注册时使用的账号
     */
    @SerializedName("register_account")
    private String registerAccount;
    /**
     * 注册时间
     */
    @SerializedName("register_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;
    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastLoginTime;
    /**
     * 用户的权限信息
     */
    private Integer grade;
    /**
     * 账号状态  0 正常使用 1禁用 2 限制使用
     */
    private Integer status;
    /**
     * 用户的注册ip
     */
    private String registerIp;
    /**
     * 用户最后登录ip
     */
    private String lastLoginIp;
    /**
     * 注册使用类型
     */
    @SerializedName("account_type")
    private Integer accountType;
}