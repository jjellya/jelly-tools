package edu.dev.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.dev.backend.entity.SysUser;
import edu.dev.backend.utils.Result;

/**
 * Create By  @林俊杰
 * 2022/3/15 21:07
 *
 * @version 1.0
 */
public interface SysUserService extends IService<SysUser> {

    boolean addSysUser(SysUser user);

    Result register(SysUser user);

    Result checkEmail(String email);

    SysUser findOneByName(String nickName);/*返回nickname匹配的第一个用户*/

    SysUser findOneByEmail(String email);

    SysUser findOneById(Integer id);
}
