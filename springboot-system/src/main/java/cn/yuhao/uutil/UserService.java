package cn.yuhao.uutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Autowired
//    private UserMapper userMapper;
    public User findByUsername(User user){
        return new User("111","zhangsan","123456");
//        return userMapper.findByUsername(user.getUsername());
    }
    public User findUserById(String userId) {
//        return userMapper.findUserById(userId);
        return new User("111","zhangsan","123456");
    }
}
