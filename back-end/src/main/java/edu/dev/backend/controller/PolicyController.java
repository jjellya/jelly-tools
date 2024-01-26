package edu.dev.backend.controller;


import edu.dev.backend.VO.informationBoard.InfoBoardVO;
import edu.dev.backend.VO.informationBoard.InfoDataVO;
import edu.dev.backend.VO.policyDetail.PolicyDetailVO;
import edu.dev.backend.VO.policyDetail.PolicyVO;
import edu.dev.backend.VO.sysUser.UserLoginVO;
import edu.dev.backend.VO.sysUser.UserRoleVO;
import edu.dev.backend.entity.Policy;
import edu.dev.backend.entity.SysUser;
import edu.dev.backend.entity.Tag;
import edu.dev.backend.enums.UserIdentityEnum;
import edu.dev.backend.service.*;
import edu.dev.backend.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 政策文件表 前端控制器
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
@Controller
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private SysUserService userService;

    @Autowired
    private TagRefService tagRefService;

    @Autowired
    private SysDeptService deptService;

    @Autowired
    private TagService tagService;

    @GetMapping(value = "getPolicyDetailData")
    public Object getPolicyDetailData(@RequestParam("policy_id") String policy_id, HttpServletRequest request){
        Integer policyId = Integer.valueOf(policy_id);
        SysUser sysUser = UserIdentityUtil.verifyIdentityReturnUser(request, userService);
        UserRoleVO roleVO = new UserRoleVO();
        if (sysUser!=null){
            roleVO.setUserRole(sysUser.getRole());
            roleVO.setUserName(sysUser.getNickName());
            roleVO.setUserId(sysUser.getId());
        }else{
            roleVO.setUserRole(UserIdentityEnum.VISITOR.getCode());
            roleVO.setUserName(null);
            roleVO.setUserId(null);
        }
        PolicyVO policyVO = policyService.getPolicyDetailById(policyId);
        PolicyDetailVO policyDetailVO = new PolicyDetailVO();
        policyDetailVO.setPolicy(policyVO); policyDetailVO.setUser(roleVO);
        return ResultVOUtil.success(policyDetailVO);
    }

    @PostMapping(value = "updatePolicyDetailData")
    public Object updatePolicyDetailData(@RequestBody PolicyVO data){
        Integer postId = Integer.valueOf(data.getPolicy_id().toString());
        String textContent = data.getText_content();
        System.out.println("postId = "+postId+";\npost_content======>\n"+textContent);
        Policy policy = VO2EntityUtil.policyVO2policy(data,deptService);
        List<Tag> tags = VO2EntityUtil.policyVO2TagList(data,tagService);
        policyService.updatePolicy(policy);
        tagRefService.addTagRefByPolicyId(postId,tags);
        return Result.success();
    }

    @GetMapping(value = "getInformationBoardData")
    public Object getInformationBoardData(@RequestParam("policy_type") String policy_type,
                                          @RequestParam("index") String page_index,
                                          @RequestParam("size") String page_size,
                                          HttpServletRequest request){
        Integer policyType = Integer.valueOf(policy_type);
        Integer index = Integer.valueOf(page_index);
        Integer size = Integer.valueOf(page_size);

        System.out.println("进来了,policy_type = "+policy_type);

//        boolean isEmployee = false;
//        if(UserIdentityUtil.verifyIdentity(request,userService)== UserIdentityEnum.EMPLOYEE.getCode())
//            isEmployee = true;
        //Integer userRole = UserIdentityUtil.verifyIdentity(request,userService);
        SysUser sysUser = UserIdentityUtil.verifyIdentityReturnUser(request,userService);

        List<InfoDataVO> data = policyService.getPolicyDescriptionByType(policyType, index - 1, size);
        Integer total = policyService.getPolicyNumByType(policyType);

        UserRoleVO userRoleVO = new UserRoleVO();
        if(sysUser!=null){
            userRoleVO.setUserName(sysUser.getNickName());
            userRoleVO.setUserId(sysUser.getId());
            userRoleVO.setUserRole(sysUser.getRole());
        }else{
            userRoleVO = null;
        }

        InfoBoardVO infoBoardVO = new InfoBoardVO();
        infoBoardVO.setInfoDataList(data);infoBoardVO.setTotal(total);
        infoBoardVO.setUser(userRoleVO);

        return ResultVOUtil.success(infoBoardVO);
    }

    /*
    const res2  =this.$http.post('/api/updatePolicyDetailData',post_detail);

                res2.then(result2 =>{
                    if(result2.code !== 200) {
                        return this.$message.error('更新失败');
                    }else {
                        return this.$message.success('更新成功');
                    }
                });
                */
}

