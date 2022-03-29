package cn.yuhao.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author yuhao
 * @date 2022/3/29 8:17 下午
 * @description
 * @iphone
 */


@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdectGradeentity {

    /**
     * 商品编号id
     */
    private String id;
    /**
     * 商品名称
     */
    private String title;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 商品图片
     */
    private String img;
    /**
     *商品排序
     */
    private String desc;
    /**
     * 商品添加时间
     */
    private Date addTime;
    /**
     * 商品状态 -1 已删除 0 下架 1上架
     */
    private Integer status;
    /**
     * 和商品表关联id
     */
    private String productId;
    /**
     * 商品成本
     */
    private Double cost;
    /**
     * 商品宽度
     */
    private Integer wight;
    /**
     * 商品库存
     */
    private Integer stock;

}