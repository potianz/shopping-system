//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author imyzt
 * @date 2022/03/21
 * @description 描述信息
 */
@SpringBootApplication
//@MapperScan(value = {"cn.ideamake.yxproperty.docking.mapper"})
//@EnableScheduling
//@EnableAspectJAutoProxy
@ComponentScan("cn.yuhao")
@MapperScan(value = {"cn.yuhao.mapper"})
public class Application  {
    public static void main(String[] args) {
         SpringApplication.run(Application.class,args);
    }
}