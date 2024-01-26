package edu.dev.backend.service.impl;

import edu.dev.backend.service.PolicyService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Create By  @林俊杰
 * 2022/3/27 21:40
 *
 * @version 1.0
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PolicyServiceImplTest {
    @Autowired
    private PolicyService policyService;

    @Test
    void getPolicyDescriptionByType() {
        System.out.println(policyService.getPolicyDescriptionByType(2, 0, 10));
    }

    @Test
    void getPolicyNumByType() {
        System.out.println(policyService.getPolicyNumByType(3));
    }


}
