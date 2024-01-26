package edu.dev.backend.service;

import edu.dev.backend.entity.PbInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import edu.dev.backend.utils.Result;

/**
 * <p>
 * 依申请公开登记表 服务类
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
public interface PbInfoService extends IService<PbInfo> {

    Result addPbInfo(PbInfo pbInfo);


}
