package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.dev.backend.VO.informationBoard.InfoDataVO;
import edu.dev.backend.VO.policyDetail.PolicyVO;
import edu.dev.backend.VO.policyDetail.TagVO;
import edu.dev.backend.entity.Policy;
import edu.dev.backend.dao.PolicyMapper;
import edu.dev.backend.entity.Tag;
import edu.dev.backend.enums.UserIdentityEnum;
import edu.dev.backend.service.PolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.dev.backend.service.SysDeptService;
import edu.dev.backend.service.TagRefService;
import edu.dev.backend.utils.LocationAdapterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 政策文件表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {
    @Autowired
    private SysDeptService deptService;

    @Autowired
    private TagRefService tagRefService;


    @Override
    public PolicyVO getPolicyDetailById(Integer policyId) {
        PolicyVO res = new PolicyVO();
        try {
            Policy policy = baseMapper.selectById(policyId);

            res.setCreate_date(policy.getCreateTime());
            boolean introduce_visible = false;
            if(policy.getType()==1) introduce_visible=true;
            res.setIntroduce_visible(introduce_visible);
            res.setIssue_number(policy.getCode());
            res.setLocation(LocationAdapterUtils.policyType2Location(policy.getType()));
            res.setPolicy_id(policyId);
            res.setPost_agency(deptService.findOneById(policy.getAuthor()).getDeptName());
            res.setText_content(policy.getContent());
            res.setRelease_date(policy.getUpdateTime());
            res.setText_title(policy.getTitle());
            res.setValidity(true);
            List<Tag> tagList = tagRefService.getTagListByPolicyId(policyId);
            if(tagList!=null&&!tagList.isEmpty()){
                List<TagVO> tagVOList = new ArrayList<>();
                for (Tag tag:tagList
                ) {
                    TagVO tagVO = new TagVO();
                    tagVO.setTag_content(tag.getContent());
                    tagVO.setTag_id(tag.getId());
                    tagVOList.add(tagVO);
                }
                res.setPost_tags(tagVOList);
            }
        }catch (Exception e){
            log.error("查找id = "+policyId+"的文章失败\n"+e.toString());
        }
        return res;
    }

    @Override
    public List<InfoDataVO> getPolicyDescriptionByType(Integer type, Integer index, Integer size) {
        List<InfoDataVO> resList = new ArrayList<>();
        try {
            QueryWrapper<Policy> wrapper = new QueryWrapper<>();
            wrapper.eq("type",type);
            wrapper.last("limit "+index+", "+size);
            List<Policy> list = baseMapper.selectList(wrapper);
            System.out.println("list.size = "+list.size());
            for (Policy policy : list) {
                InfoDataVO infoVO = new InfoDataVO();
                infoVO.setPolicy_id(policy.getId());
                infoVO.setDate(policy.getUpdateTime());
                infoVO.setTitle(policy.getTitle());
                resList.add(infoVO);
            }
        }
        catch (Exception e){
            System.out.println("出错了");
            log.error(e.toString());
        }
        return resList;
    }

    @Override
    public Integer getPolicyNumByType(Integer type) {
        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        Integer res = baseMapper.selectCount(wrapper);
        return res;
    }

    @Override
    public Integer updatePolicy(Policy policy) {
        int res = 0;
        try {
            res = baseMapper.updateById(policy);

        }catch (Exception e){
            log.error("更新Policy出错,policy_id = "+policy.getId()+", "+e.toString());
        }
        return res;
    }
}
