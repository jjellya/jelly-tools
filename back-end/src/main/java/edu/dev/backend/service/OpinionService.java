package edu.dev.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.dev.backend.entity.Opinion;

import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/31 9:43
 *
 * @version 1.0
 */
public interface OpinionService extends IService<Opinion> {
    Integer addOpinion(Opinion opinion);

    List<Opinion> getOpinionListByPolicyId(Integer policyId);
}
