package edu.dev.backend.service.impl;

import edu.dev.backend.service.SysDeptService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create By  @林俊杰
 * 2022/3/29 12:06
 *
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SysDeptServiceImplTest {

    @Autowired
    SysDeptService deptService;

    @Test
    void findOneByName() {
        System.out.println(deptService.findOneByName("镇人民政府"));
    }
}
