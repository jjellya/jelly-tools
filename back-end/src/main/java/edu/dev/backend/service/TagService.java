package edu.dev.backend.service;

import edu.dev.backend.entity.Tag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
public interface TagService extends IService<Tag> {
    Tag findOneByContent(String content);

    Tag addTagByContent(String content);
}
