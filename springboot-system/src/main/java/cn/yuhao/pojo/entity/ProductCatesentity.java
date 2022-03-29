package cn.yuhao.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author yuhao
 * @date 2022/3/29 8:32 下午
 * @description
 * @iphone
 */



@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCatesentity {
    /**
     * 商品主键
     */
    private String id;
    /**
     * 上级分类 0 为最高分类 1为二级分类 数字越大分类越靠后
     */
    private Integer pid;
    /**
     * 排序
     */
    private String ord;
    /**
     * 标签标题，分类名称
     */
    private String title;
    /**
     * 产品状态 0 正常 1 禁用
     */
    private Integer status;
    /**
     * 添加时间
     */
    private Date addTime;

}