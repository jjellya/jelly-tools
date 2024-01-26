package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.dev.backend.entity.Policy;
import edu.dev.backend.entity.SysDept;
import edu.dev.backend.dao.SysDeptMapper;
import edu.dev.backend.service.SysDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public SysDept findOneById(Integer id) {
        SysDept dept =baseMapper.selectById(id);
        if(dept == null) log.error("查询不到id为"+id+"的部门");
        return dept;
    }

    @Override
    public SysDept findOneByName(String deptName) {
        SysDept dept = null;
        try {
            QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
            wrapper.like("dept_name",deptName);
            dept =baseMapper.selectOne(wrapper);
        }catch (Exception e){
            System.out.println("查找dept_name为"+deptName+"的部门失败");
            log.error(e.toString());
        }
        return dept;
    }
}
