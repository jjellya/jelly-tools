package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.dev.backend.entity.Tag;
import edu.dev.backend.entity.TagRef;
import edu.dev.backend.dao.TagRefMapper;
import edu.dev.backend.service.TagRefService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标签联系表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class TagRefServiceImpl extends ServiceImpl<TagRefMapper, TagRef> implements TagRefService {


    @Autowired
    private TagRefMapper tagRefMapper;

    @Override
    public List<Tag> getTagListByPolicyId(Integer policyId) {
        List<Tag> tags = null;
        try {
            tags = tagRefMapper.getTagListByPolicyId(policyId);
            if (tags==null||tags.isEmpty()){
                System.out.println("标签列表查找失败");
                return null;
            }
        }catch (Exception e){
            System.out.println("获取标签链表出错,getTagListByPolicyId(policyId = "+policyId+")");
            log.error(e.toString());
        }
        return tags;
    }

    @Override
    public Integer addTagRefByPolicyId(Integer policyId, List<Tag> tagList) {
        Integer res = 0;
        try {
            deleteTagRefByPolicyId(policyId);
            for (Tag tag:tagList) {
                TagRef tagRef = new TagRef();
                tagRef.setPolicyId(policyId);
                tagRef.setTagId(tag.getId());
                res+=baseMapper.insert(tagRef);
            }
        }catch (Exception e){
            res = 0;
            System.out.println("更新policy_id="+policyId+"的标签连接失败");
            log.error(e.toString());
        }
        return res;
    }

    @Override
    public Integer deleteTagRefByPolicyId(Integer policyId) {
        Integer res = 0;

        try {
            QueryWrapper<TagRef> wrapper = new QueryWrapper<>();
            wrapper.eq("policy_id",policyId);
            res = baseMapper.delete(wrapper);
        }catch (Exception e){
            System.out.println("删除policy_id="+policyId+"的标签连接失败");
            log.error(e.toString());
        }
        return res;
    }
}
