package edu.dev.backend.utils;

import edu.dev.backend.entity.SysUser;
import edu.dev.backend.enums.UserIdentityEnum;
import edu.dev.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Create By  @林俊杰
 * 2022/3/28 12:04
 *
 * @version 1.0
 */
public class UserIdentityUtil {

    public static Integer verifyIdentity(HttpServletRequest request,SysUserService userService){
        Integer res = UserIdentityEnum.VISITOR.getCode();//默认为游客
        String token = request.getHeader("token");

        // 执行认证
        if (token == null) {
            //这里其实是登录失效,没token了
            System.out.println("没token啊");
            return res;
        }
        // 获取 token 中的 userId
        try {
            String userId = JwtUtils.getAudience(token);

            // 判断是否存在这个用户
            SysUser user = userService.findOneById(Integer.valueOf(userId));
            if (user == null) {
                // 没有则抛出异常
                System.out.println("查找不到这个用户,用户ID = "+userId);
            }

            // 验证 token ，如果验证失败则抛出异常，则请求失败
            JwtUtils.verifyToken(token, userId);
            if (user.getRole()==UserIdentityEnum.EMPLOYEE.getCode())
                res = UserIdentityEnum.EMPLOYEE.getCode();
            else if(user.getRole()==UserIdentityEnum.NORMAL.getCode())
                res = UserIdentityEnum.NORMAL.getCode();

            //获取载荷内容
            String email = JwtUtils.getClaimByName(token, "email").asString();
            String password = JwtUtils.getClaimByName(token, "password").asString();

            //放入attribute以便后面调用
            request.setAttribute("email", email);
            request.setAttribute("password", password);
        }catch (Exception e){
            System.out.println("未知错误");
            return res;
        }

        return  res;
    }

    public static SysUser verifyIdentityReturnUser(HttpServletRequest request,SysUserService userService){
        SysUser res = null;//默认为游客
        String token = request.getHeader("token");

        // 执行认证
        if (token == null) {
            //这里其实是登录失效,没token了
            System.out.println("没token啊");
            return res;
        }
        // 获取 token 中的 userId
        try {
            String userId = JwtUtils.getAudience(token);

            // 判断是否存在这个用户
            SysUser user = userService.findOneById(Integer.valueOf(userId));
            if (user == null) {
                // 没有则抛出异常
                System.out.println("查找不到这个用户,用户ID = "+userId);
            }

            // 验证 token ，如果验证失败则抛出异常，则请求失败
            JwtUtils.verifyToken(token, userId);
            res = user;

            //获取载荷内容
            String email = JwtUtils.getClaimByName(token, "email").asString();
            String password = JwtUtils.getClaimByName(token, "password").asString();

            //放入attribute以便后面调用
            request.setAttribute("email", email);
            request.setAttribute("password", password);
        }catch (Exception e){
            System.out.println("未知错误");
            return res;
        }

        return  res;
    }
}
