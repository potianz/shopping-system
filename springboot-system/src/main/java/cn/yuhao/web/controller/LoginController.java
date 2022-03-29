package cn.yuhao.web.controller;

import cn.yuhao.comment.PassToken;
import cn.yuhao.pojo.dto.UserLoginDTO;
import cn.yuhao.pojo.entity.Userentity;
import cn.yuhao.service.RegisterService;
import cn.yuhao.service.TokenService;
import cn.yuhao.uutil.User;
import cn.yuhao.service.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Wrapper;


/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @Autowired
    private RegisterService registerService;


    @PassToken
    @PostMapping("/user")
    public Object login(@RequestBody UserLoginDTO user, HttpServletRequest request,HttpServletResponse response) {
        log.info("用户登录信息：{}",user.toString());
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        UserLoginDTO userLoginDTO = userService.getUser(user);
        if(userLoginDTO.getUserName() == null){
            jsonObject.put("message","登录失败,该用户没有注册！");
            return jsonObject;
        }
        if (!userLoginDTO.getUserPassword().equals(user.getUserPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            return jsonObject;
        } else {
            //获得一个token
            String token = tokenService.getToken(userLoginDTO);
            jsonObject.put("im_token", token);
            Cookie cookie = new Cookie("im_token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            jsonObject.put("message","登录成功！");
            return jsonObject;
        }

    }
}