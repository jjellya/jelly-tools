package edu.dev.backend.dao;

import edu.dev.backend.entity.Tag;
import edu.dev.backend.entity.TagRef;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 标签联系表 Mapper 接口
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Mapper
public interface TagRefMapper extends BaseMapper<TagRef> {
    //获取用户列表
    List<Tag> getTagListByPolicyId(int policyId);
}
