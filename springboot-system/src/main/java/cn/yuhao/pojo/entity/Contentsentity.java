package cn.yuhao.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuhao
 * @date 2022/3/29 8:28 下午
 * @description
 * @iphone
 */


@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contentsentity {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 商品编号
     */
    private String productGreadeId;
    /**
     * 商品详细描述
     */
    private String contents;
}