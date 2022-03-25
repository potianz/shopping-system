package cn.yuhao.pojo.vo;


/**
 * @author imyzt
 * @date 2022/03/24
 * @description 描述信息
 */


import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CheckResult {
    private boolean success;
    private Claims claims;
    private String errCode;
}

