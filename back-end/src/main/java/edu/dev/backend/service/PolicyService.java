package edu.dev.backend.service;

import edu.dev.backend.VO.informationBoard.InfoDataVO;
import edu.dev.backend.VO.policyDetail.PolicyVO;
import edu.dev.backend.entity.Policy;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 政策文件表 服务类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
public interface PolicyService extends IService<Policy> {
    PolicyVO getPolicyDetailById(Integer policyId);

    List<InfoDataVO> getPolicyDescriptionByType(Integer type, Integer index, Integer size);

    Integer getPolicyNumByType(Integer type);

    Integer updatePolicy(Policy policy);
}
