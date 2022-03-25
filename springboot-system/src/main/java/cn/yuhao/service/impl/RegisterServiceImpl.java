package cn.yuhao.service.impl;


import cn.yuhao.mapper.RegisterMapper;
import cn.yuhao.pojo.dto.UserRegisterDTO;
import cn.yuhao.pojo.entity.UserMsgentity;
import cn.yuhao.pojo.entity.Userentity;
import cn.yuhao.service.RegisterService;
import cn.yuhao.util.RandomCode;
import cn.yuhao.uutil.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import static cn.yuhao.util.RandomCode.random;

/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */
@Service
@Slf4j
//@AllArgsConstructor
public class RegisterServiceImpl  extends ServiceImpl<RegisterMapper, Userentity>  implements RegisterService {


    @Autowired
    private RegisterMapper registerMapper;

    //将用户传入的数据进行存入
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean registerUser(UserRegisterDTO registerDTO, HttpServletRequest request) {
        //生成一个32位的随机数，用户id
        String   rid= RandomCode.random();
        //生成用户账号
        String username = RandomCode.randomAccount(11);
        Userentity userentity = new Userentity();
        UserMsgentity userMsgentity = new UserMsgentity();
        userentity.setRid(rid);
        userentity.setUserName(username);
        userentity.setUserPassword(registerDTO.getUserPassword());
        Integer accountType = registerDTO.getAccountType();
        //注册账号类型
        switch (accountType){
            case 0: userentity.setRegisterAccount(registerDTO.getUserEmil());
            userMsgentity.setUserEmil(registerDTO.getUserEmil());
            break;
            case 1: userentity.setRegisterAccount(registerDTO.getPhone());
            break;
            case 2:userentity.setRegisterAccount(registerDTO.getWechat());
            break;
            case 3:userentity.setRegisterAccount(registerDTO.getAlipay());
            break;
        }
        userentity.setAccountType(accountType);
        userentity.setRegisterTime(new Date());
        userentity.setGrade(0);
        userentity.setStatus(0);
        userMsgentity.setRid(rid);
        userMsgentity.setUserNickname(registerDTO.getUserNickname());
        userMsgentity.setUserSex(registerDTO.getUserSex());
        userentity.setRegisterIp(getIp(request));
        registerMapper.insert(userentity);
        registerMapper.insertUserMsg(userMsgentity);
        return true;
    }
    public String getIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}