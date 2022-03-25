package cn.yuhao.service;

import cn.yuhao.pojo.dto.UserRegisterDTO;
import cn.yuhao.pojo.entity.Userentity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */

public interface RegisterService extends IService<Userentity>{

    boolean registerUser(UserRegisterDTO registerDTO, HttpServletRequest httpRequest);
}