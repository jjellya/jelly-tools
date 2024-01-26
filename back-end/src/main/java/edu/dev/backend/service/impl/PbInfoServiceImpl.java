package edu.dev.backend.service.impl;

import edu.dev.backend.entity.PbInfo;
import edu.dev.backend.dao.PbInfoMapper;
import edu.dev.backend.service.PbInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.dev.backend.utils.Result;
import edu.dev.backend.utils.ResultVOUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 依申请公开登记表 服务实现类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@Service
public class PbInfoServiceImpl extends ServiceImpl<PbInfoMapper, PbInfo> implements PbInfoService {

    @Override
    public Result addPbInfo(PbInfo pbInfo) {
        int res = 0;
        try{
            res = baseMapper.insert(pbInfo);
        }catch (Exception e){
            System.out.println("插入依申请公开记录失败！");
            log.error(e.toString());
        }
        if (res==0) return Result.errorMsg("插入依申请公开记录失败！");
        else return Result.success();
    }
}
