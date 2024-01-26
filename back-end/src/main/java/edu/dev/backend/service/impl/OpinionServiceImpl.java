package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.dev.backend.dao.OpinionMapper;
import edu.dev.backend.entity.Opinion;
import edu.dev.backend.service.OpinionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/31 9:44
 *意见征集登记表 服务实现类
 * @version 1.0
 */
@Service
public class OpinionServiceImpl extends ServiceImpl<OpinionMapper, Opinion> implements OpinionService {
    @Override
    public Integer addOpinion(Opinion opinion) {
        Integer res = 0;
        try {
            res = baseMapper.insert(opinion);
        }catch (Exception e){
            log.error("插入Opinion记录失败,"+e.toString());
        }
        return res;
    }

    @Override
    public List<Opinion> getOpinionListByPolicyId(Integer policyId) {
        List<Opinion> resList = null;
        try {
            QueryWrapper<Opinion> wrapper = new QueryWrapper<>();
            wrapper.eq("policy_id",policyId);
            wrapper.last("limit "+0+", "+20);
            resList = baseMapper.selectList(wrapper);
            if (resList==null||resList.isEmpty()){
                resList = null;
            }
        }catch (Exception e){
            log.error("获取policy_id = "+policyId+"的意见失败\n"+e.toString());
        }
        return resList;
    }
}
