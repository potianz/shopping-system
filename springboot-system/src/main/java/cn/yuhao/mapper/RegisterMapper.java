package cn.yuhao.mapper;


import cn.yuhao.pojo.entity.UserMsgentity;
import cn.yuhao.pojo.entity.Userentity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */
@Repository
public interface RegisterMapper  extends BaseMapper<Userentity> {

    Integer insertUserMsg(@Param("msg")UserMsgentity userMsgentity);
}