package cn.yuhao.service;

import cn.yuhao.pojo.dto.UserLoginDTO;
import cn.yuhao.pojo.entity.Userentity;
import cn.yuhao.uutil.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService extends IService<Userentity> {

    UserLoginDTO getUser(UserLoginDTO userLoginDTO);
    UserLoginDTO getUserById(String id);
}
