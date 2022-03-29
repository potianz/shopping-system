package cn.yuhao.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author yuhao
 * @date 2022/3/29 8:37 下午
 * @description
 * @iphone
 */



@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class productImg {

    /**
     * 主键 自增
     */
    private Integer id;
    /**
     * 商品编号id
     */
    private String productGradeId;
    /**
     * 图片路径
     */
    private String img;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 图片名称
     */
    private String name;
    /**
     * 图片扩展名
     */
    private String ext;
    /**
     * 图片大小
     */
    private Integer size;

}