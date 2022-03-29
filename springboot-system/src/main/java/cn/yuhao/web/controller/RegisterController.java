package cn.yuhao.web.controller;

import cn.yuhao.pojo.dto.UserRegisterDTO;
import cn.yuhao.service.MailService;
import cn.yuhao.service.RegisterService;
import cn.yuhao.comment.PassToken;
import cn.yuhao.comment.UserLoginToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import cn.yuhao.common.Result;


/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */
@Slf4j
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private MailService mailService;

    @PostMapping("/user")
    @PassToken
    public Result registerUser(@Valid UserRegisterDTO registerDTO, HttpServletRequest request){
        log.info("registerDTO:{}",registerDTO.toString());
        boolean message = registerService.registerUser(registerDTO,request);
        if(message){
            //应该跳转到登录页面或者直接登录
            return  Result.ok("注册成功");
        }
        return Result.error("注册失败！");
    }

    @PostMapping("/sendEmail")
    @ResponseBody
    @UserLoginToken
    public String sendEmail(@RequestParam("email")String email , HttpSession httpSession){
        log.info("email:{}",email);
        mailService.sendMimeMail(email,httpSession);
        return "success";
    }

    public String sendPhone(@RequestParam("phone")String phone,HttpSession httpSession){
        log.info("phone:{}",phone);
        return "success";
    }
}