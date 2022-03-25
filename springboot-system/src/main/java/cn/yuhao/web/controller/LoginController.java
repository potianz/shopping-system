package cn.yuhao.web.controller;

import cn.yuhao.comment.PassToken;
import cn.yuhao.service.RegisterService;
import cn.yuhao.service.TokenService;
import cn.yuhao.uutil.User;
import cn.yuhao.uutil.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


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
    @PostMapping()
    public Object login(User user, HttpServletResponse response) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = new User();
        userForBase.setUsername(userService.findByUsername(user).getUsername());
        userForBase.setPassword(userService.findByUsername(user).getPassword());
        if(userForBase.getUsername() == null){
            jsonObject.put("message","登录失败,该用户没有注册！");
            return jsonObject;
        }
        if (!userForBase.getPassword().equals(user.getPassword())) {
            jsonObject.put("message", "登录失败,密码错误");
            return jsonObject;
        } else {
            //获得一个token
            String token = tokenService.getToken(userForBase);
            jsonObject.put("im_token", token);
            Cookie cookie = new Cookie("im_token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            jsonObject.put("message","登录成功！");
            return jsonObject;
        }

    }
}