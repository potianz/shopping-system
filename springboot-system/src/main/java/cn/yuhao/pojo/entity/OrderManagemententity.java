package cn.yuhao.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author yuhao
 * @date 2022/3/29 8:45 下午
 * @description
 * @iphone
 */


@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderManagemententity {
    /**
     * 订单id
     */
    private String id;
    /**
     * 收件人姓名
     */
    private String  name;
    /**
     * 收件人手机
     */
    private String phone;
    /**
     * 收件人地址
     */
    private String consigneeAddress;
    /**
     * 关联id
     */
    private String relevanceId;
    /**
     * 订单状态 订单状态 0 用户付款 商家未处理 1 商家发货 2退货中  3订单取消
     */
    private Integer status;
    /**
     * 订单创建时间
     */
    private Date createdAt;
    /**
     * 订单修改时间
     */
    private Date updatedAt;
}