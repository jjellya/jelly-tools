package edu.dev.backend.service.impl;

import edu.dev.backend.entity.PbLeader;
import edu.dev.backend.dao.PbLeaderMapper;
import edu.dev.backend.service.PbLeaderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 领导简介表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class PbLeaderServiceImpl extends ServiceImpl<PbLeaderMapper, PbLeader> implements PbLeaderService {

}
