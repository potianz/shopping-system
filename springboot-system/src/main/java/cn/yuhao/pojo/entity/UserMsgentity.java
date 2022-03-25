package cn.yuhao.pojo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

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
public class UserMsgentity implements Serializable {
    /**
     * 主键
     */
    private String rid;
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
     * 用户订单信息关联id
     */
    private String  userIndentRid;

    /**
     * 用户历史访问表关联id
     */
    private String userHistoryVisit;
    /**
     * 用户收藏表关联id
     */
    private String userColectRid;
}