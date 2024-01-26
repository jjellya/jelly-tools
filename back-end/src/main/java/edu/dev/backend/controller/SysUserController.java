package edu.dev.backend.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import edu.dev.backend.VO.sysUser.UserLoginVO;
import edu.dev.backend.config.MySessionContext;
import edu.dev.backend.entity.SysUser;
import edu.dev.backend.security.JwtAuthenticatioToken;
import edu.dev.backend.service.SysUserService;
import edu.dev.backend.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private Producer producer;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static String sessionId;

    @PostMapping(value = "register")
    public Object registerID(@RequestBody Map<String, String> form){
        System.out.println("进来了");
//        Integer id = Integer.valueOf(form.get("id"));
//        String password = form.get("password");
//        return "id :"+id+", pwd:"+password+"\n other things:"+form;
        String email = form.get("email");
        String nickname = form.get("userName");
        String password =form.get("password");
        String passwordAgain = form.get("passwordAgain");
        if(!password.equals(passwordAgain)) return Result.error();


        SysUser user = new SysUser();
        user.setNickName(nickname);
        user.setPassword(password);
        user.setEmail(email);
        user.setSalt("helloSalt");
        user.setStatus(1);
        System.out.println("User:====>\n"+ user.toString());
        return sysUserService.register(user);
    }

    @PostMapping(value = "checkEmail")
    public Object checkMail(@RequestBody Map<String, String> form){
        String email = form.get("email");
        System.out.println("email====>"+email);
        return sysUserService.checkEmail(email);
    }

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute("captcha", text);
        HttpSession session = request.getSession();
        MySessionContext.addSession(session);
        sessionId = session.getId();

        System.out.println("text = "+text);
        ServletOutputStream out = response.getOutputStream();

        //OutputStreamWriter ow = new OutputStreamWriter(out,"GB2312");
        //ow.write(sessionId);
        System.out.println(sessionId);
        //ow.flush();

        //ow.close();

        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/login")
    public Object login(@RequestBody Map<String, String> form,HttpServletRequest request) throws IOException {
        String email = form.get("email");
        String password = form.get("password");
        String captcha = form.get("captcha");
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        System.out.println(request.getRemoteAddr());
        Object kaptcha = MySessionContext.getSession(sessionId).getAttribute("captcha");
        if(kaptcha == null){
            return Result.errorMsg("验证码失效");
        }
        if(!captcha.equals(kaptcha)){
            return Result.errorMsg("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.findOneByEmail(email);
        System.out.println("====>"+user.toString());
        // 账号不存在、密码错误
        if (user == null) {
            return Result.errorMsg("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), user.getPassword(),password)) {
            System.out.println("密码应该为："+PasswordUtils.encode(user.getPassword(),user.getSalt()));
            System.out.println("用户输入的为："+password);
            return Result.errorMsg("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return Result.errorMsg("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        System.out.println("来到了这里1");
//        JwtAuthenticatioToken token = SecurityUtils.login(request, email, password, authenticationManager);
        String token = JwtUtils.createToken(user.getId().toString(),user.getEmail(),user.getPassword());
        System.out.println("来到了这里2");
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setToken(token);
        userLoginVO.setUserId(user.getId());
        userLoginVO.setUserName(user.getNickName());
        return ResultVOUtil.success(userLoginVO);
    }

}

