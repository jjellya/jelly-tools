package edu.dev.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Create By  @林俊杰
 * 2022/3/19 19:40
 *
 * @version 1.0
 */
@Configuration
public class JwtInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //默认拦截所有路径
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/api/complain")
//                .excludePathPatterns("/api/login","/api/captcha.jpg","/activate","/register.html","/register",
//                        "/api/updatePolicyDetailData","/api/getPolicyDetailData","/api/**",
//                        "/swagger-ui.html","/swagger-resources/**","/v2/api-docs","/webjars/springfox-swagger-ui/**"
//                        ,"/css/**","/js/**","/img/**");
    }

    @Bean
    public JwtAuthInterceptor authenticationInterceptor() {
        return new JwtAuthInterceptor();
    }
}
