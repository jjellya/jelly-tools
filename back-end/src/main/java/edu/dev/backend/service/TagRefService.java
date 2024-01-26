package edu.dev.backend.service;

import edu.dev.backend.entity.Tag;
import edu.dev.backend.entity.TagRef;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 标签联系表 服务类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
public interface TagRefService extends IService<TagRef> {
    List<Tag> getTagListByPolicyId(Integer policyId);

    Integer addTagRefByPolicyId(Integer policyId,List<Tag> tagList);

    Integer deleteTagRefByPolicyId(Integer policyId);
}
