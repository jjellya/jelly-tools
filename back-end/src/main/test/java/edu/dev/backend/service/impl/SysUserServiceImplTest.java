package edu.dev.backend.service.impl;

import edu.dev.backend.entity.SysUser;
import edu.dev.backend.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Create By  @林俊杰
 * 2022/3/15 21:22
 *
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SysUserServiceImplTest {

    @Autowired
    SysUserService sysUserService;

    @Test
    public void addSysUser() {
        SysUser user = new SysUser();
        user.setNickName("张三");
        user.setId(2);
        sysUserService.addSysUser(user);
    }
}
