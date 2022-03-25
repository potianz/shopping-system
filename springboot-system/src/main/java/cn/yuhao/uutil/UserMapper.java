package cn.yuhao.uutil;

import cn.yuhao.pojo.dto.UserRegisterDTO;
import cn.yuhao.uutil.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.poi.util.Beta;
import org.springframework.stereotype.Repository;

/**
 * @author qiaoyn
 * @date 2019/06/14
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserRegisterDTO> {
    @Select("select id,name,password from user where name=#{name} ")
    User findByUsername(String username);
    @Select("select id,name,password from user where name=#{name} ")
    User findUserById(String id);

}
