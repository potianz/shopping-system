package cn.yuhao.pojo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * @author imyzt
 * @date 2022/03/29
 * @description 描述信息
 */
@Data
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

    private String rid;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("userpassword")
    private String userPassword;
}