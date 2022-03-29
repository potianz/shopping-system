package cn.yuhao.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuhao
 * @date 2022/3/29 8:40 下午
 * @description
 * @iphone
 */


@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderMessageentity {

    /**
     * 订单信息id
     */
    private String id;
    /**
     * 关联id
     */
    private String relevanceId;
    /**
     * 商品编号id
     */
    private String productGradeId;
    /**
     * 商品单价
     */
    private Double productPrice;
    /**
     * 商品数量
     */
    private Integer productNums;
    /**
     * 商品总价
     */
    private Double totalPrice;
}