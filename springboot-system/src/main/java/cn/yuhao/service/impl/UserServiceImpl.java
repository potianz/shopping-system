package cn.yuhao.service.impl;


import cn.yuhao.mapper.RegisterMapper;
import cn.yuhao.mapper.UserMapper;
import cn.yuhao.pojo.dto.UserLoginDTO;
import cn.yuhao.pojo.entity.Userentity;
import cn.yuhao.service.RegisterService;
import cn.yuhao.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author imyzt
 * @date 2022/03/29
 * @description 描述信息
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, Userentity> implements UserService {
    @Override
    public UserLoginDTO getUser(UserLoginDTO userLoginDTO) {
        Userentity user = this.lambdaQuery().eq(Userentity::getUserName,userLoginDTO.getUserName()).one();
        UserLoginDTO selectUserDTO = new UserLoginDTO();
        selectUserDTO.setUserPassword(user.getUserPassword());
        selectUserDTO.setUserName(user.getUserName());
        selectUserDTO.setRid(user.getRid());
        return selectUserDTO;
    }

    @Override
    public UserLoginDTO getUserById(String id) {
      Userentity userentity=   this.lambdaQuery().eq(Userentity::getRid,id).one();
      UserLoginDTO userLoginDTO = new UserLoginDTO();
      userLoginDTO.setRid(id);
      userLoginDTO.setUserName(userentity.getUserName());
      userLoginDTO.setUserPassword(userentity.getUserPassword());
      return userLoginDTO;
    }
}