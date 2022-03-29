package cn.yuhao.service;

import cn.yuhao.pojo.dto.UserLoginDTO;
import cn.yuhao.uutil.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/***
 * token 下发
* @author qiaoyn
* @version V1.0
 */
@Service
public class TokenService {

	public String getToken(UserLoginDTO user) {
		Date start = new Date();
		long currentTime = System.currentTimeMillis() + 60* 60 * 1000;//一小时有效时间
		Date end = new Date(currentTime);
		String token = "";
		
		token = JWT.create().withAudience(user.getRid()).withIssuedAt(start).withExpiresAt(end)
				.sign(Algorithm.HMAC256(user.getUserPassword()));
		return token;
	}
}

