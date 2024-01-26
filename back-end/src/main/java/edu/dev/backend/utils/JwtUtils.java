package edu.dev.backend.utils;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Calendar;
import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/19 19:31
 *
 * @version 1.0
 */
public class JwtUtils {

    private static final String KEY = "HELLO JJ";

    /**
     * 签发对象: 这里我们使用用户id
     * 签发时间：现在
     * 有效时间：2分钟
     * 载荷内容：暂时设计为：这个人的邮箱，这个人的密码
     * 加密密钥：这个人的id加上一串字符串
     */
    public static String createToken(String audience, String email, String password) {

        Calendar nowTime = Calendar.getInstance();
        // 这里我们过期时间2分钟，为了做测试，实际环境时间可以设置长一点
        nowTime.add(Calendar.MINUTE, 5);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(audience)   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("email", email)    //载荷 邮箱
                .withClaim("password", password)    //载荷 密码
                .sign(Algorithm.HMAC256(audience + KEY));   //加密
    }

    /**
     * 检验合法性
     * @param token
     * @param audience 签发对象，创建token时传入的
     * @throws Exception
     */
    public static void verifyToken(String token, String audience) throws Exception {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(audience + KEY)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            //效验失败,抛异常
            System.out.println("JwtUtils里的verifyToken出错");
            throw e;
        }
    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) throws Exception {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
            System.out.println("JwtUtils里的getAudience出错");
        }
        return audience;
    }


    /**
     *  通过载荷名字获取载荷的值
     * @param token jwt token
     * @param name 载荷名字
     * @return
     */
    public static Claim getClaimByName(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }
}
