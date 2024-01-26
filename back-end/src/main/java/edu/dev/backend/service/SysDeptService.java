package edu.dev.backend.service;

import edu.dev.backend.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
public interface SysDeptService extends IService<SysDept> {
    SysDept findOneById(Integer id);

    SysDept findOneByName(String deptName);
}
