package edu.dev.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.dev.backend.dao.SysUserMapper;
import edu.dev.backend.entity.SysUser;
import edu.dev.backend.enums.ResultEnum;
import edu.dev.backend.service.SysUserService;
import edu.dev.backend.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/15 21:07
 *
 * @version 1.0
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public boolean addSysUser(SysUser user) {
        SysUser user_checked =baseMapper.selectById(user.getId());
        if(user_checked!=null)
            return false;//该用户已存在
        int insert = baseMapper.insert(user);
        return insert==1;
    }

    @Override
    public Result register(SysUser user) {
        boolean res = false;
        try{

            res = addSysUser(user);
        }catch (Exception e){
            log.error(e.toString());
            return Result.error();
        }

        return res==true?Result.success200("注册成功"):Result.errorMsg("注册失败");
    }

    @Override
    public Result checkEmail(String email) {
        int total=1;
        try {
            QueryWrapper<SysUser> userWrapper = new QueryWrapper<>();
            userWrapper.eq("email",email);
            List<SysUser> userList = baseMapper.selectList(userWrapper);
            if (userList==null||userList.isEmpty()) total=0;
            else total = userList.size();
        }catch (Exception e){
            log.error(e.toString());
            return Result.errorMsg("未知错误");
        }
        if(total==0) return Result.success();
        else return Result.error();
    }

    @Override
    public SysUser findOneByName(String nickName) {
        QueryWrapper<SysUser> userWrapper = new QueryWrapper<>();
        userWrapper.eq("nick_name",nickName);
        List<SysUser> userList;
        SysUser resUser = null;
        try{
            userList = baseMapper.selectList(userWrapper);
            if(userList==null||userList.isEmpty()) log.error("Failed to find the user whose name is "+nickName);
            else{
                resUser = userList.get(0);
            }
        }catch (Exception e){
            log.error(e.toString());
        }
        return resUser;
    }

    @Override
    public SysUser findOneByEmail(String email) {
        QueryWrapper<SysUser> userWrapper = new QueryWrapper<>();
        userWrapper.eq("email",email);
        List<SysUser> userList;
        SysUser resUser = null;
        try{
            userList = baseMapper.selectList(userWrapper);
            if(userList==null||userList.isEmpty()) log.error("Failed to find the user whose email is "+email);
            else{
                resUser = userList.get(0);
            }
        }catch (Exception e){
            log.error(e.toString());
        }
        return resUser;
    }

    @Override
    public SysUser findOneById(Integer id) {
        SysUser resUser = null;
        try{
            resUser = baseMapper.selectById(id);
            if(resUser==null) log.error("Failed to find the user whose id is "+id);
        }catch (Exception e){
            log.error(e.toString());
        }
        return resUser;
    }


}
