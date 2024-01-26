package edu.dev.backend.dao;

import edu.dev.backend.entity.Policy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 政策文件表 Mapper 接口
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Mapper
public interface PolicyMapper extends BaseMapper<Policy> {

}
