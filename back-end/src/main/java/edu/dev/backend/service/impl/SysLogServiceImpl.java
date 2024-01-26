package edu.dev.backend.service.impl;

import edu.dev.backend.entity.SysLog;
import edu.dev.backend.dao.SysLogMapper;
import edu.dev.backend.service.SysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统操作日志表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
