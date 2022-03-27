package cn.yuhao.pojo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息用户注册信息类
 */
@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {
    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户性别
     */
    private Integer userSex;

    /**
     * 用户邮箱
     */
    private String userEmil;
    /**
     * 用户名
     */
    @NonNull
    private String username;

    /**
     * 用户密码
     */
    @NonNull
    private String userPassword;
    /**
     * 注册时使用的账号
     */
    @NotNull
    private String registerAccount;
    /**
     * 注册时间
     */

    private Date registerTime;

    /**
     * 注册使用的账号类型 0 邮箱 1 手机号 2微信 3支付宝
     */
    private Integer accountType;

    /**
     * 用户注册手机
     */
    private String phone;
    /**
     * 用户注册微信
     */
    private String wechat;
    /**
     * 用户注册支付宝
     */
    private String alipay;

}