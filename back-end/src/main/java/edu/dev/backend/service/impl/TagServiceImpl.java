package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.dev.backend.entity.Tag;
import edu.dev.backend.dao.TagMapper;
import edu.dev.backend.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public Tag findOneByContent(String content) {
        Tag res = null;
        try {
            QueryWrapper<Tag> wrapper = new QueryWrapper<>();
            wrapper.like("content",content);
            res = baseMapper.selectOne(wrapper);
        }catch (Exception e){
            log.error(e.toString());
        }
        return res;
    }

    @Override
    public Tag addTagByContent(String content) {
        Tag res = null;
        try {
            Tag tag = new Tag();
            tag.setContent(content);
            int insert = baseMapper.insert(tag);
            if(insert != 0) res = findOneByContent(content);
        }catch (Exception e){
            System.out.println("Tag 插入失败");
            log.error(e.toString());
        }
        return res;
    }
}
