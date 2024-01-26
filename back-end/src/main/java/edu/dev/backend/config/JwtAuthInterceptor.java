package edu.dev.backend.config;

import edu.dev.backend.entity.SysUser;
import edu.dev.backend.service.SysUserService;
import edu.dev.backend.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Create By  @林俊杰
 * 2022/3/19 19:41
 *
 * @version 1.0
 */
public class JwtAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private SysUserService userService;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //默认全部检查

        // 执行认证
        if (token == null) {
            //这里其实是登录失效,没token了
            System.out.println("没token啊");
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

            //获取载荷内容
            String email = JwtUtils.getClaimByName(token, "email").asString();
            String password = JwtUtils.getClaimByName(token, "password").asString();

            //放入attribute以便后面调用
            httpServletRequest.setAttribute("email", email);
            httpServletRequest.setAttribute("password", password);
        }catch (Exception e){
            System.out.println("未知错误");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
