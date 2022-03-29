package cn.yuhao.pojo.entity;
/**
 * @author yuhao
 * @date 2022/3/29 8:07 下午
 * @description
 * @iphone
 */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Productentity {
    /**
     * 商品id
     */
    private String id;
    /**
     * 商品分类id
     */
    private Integer cid;
    /**
     * 商品名称
     */
    private String title;
    /**
     * 关联商品详细信息
     */
    private String proId;
    /**
     * 商品搜索关键字，使用模糊查询
     */
    private String keyWords;
    /**
     * 商品图片
     */
    private String img;
    /**
     * 商品最低价格
     */
    private Double price;
    /**
     * 商品简介，广告词
     */
    private String desc;
    /**
     * 商品的点击量
     */
    private Integer pv;
}