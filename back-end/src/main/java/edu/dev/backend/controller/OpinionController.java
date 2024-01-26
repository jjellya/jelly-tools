package edu.dev.backend.controller;

import edu.dev.backend.VO.opinion.OpinionVO;
import edu.dev.backend.entity.Opinion;
import edu.dev.backend.service.OpinionService;
import edu.dev.backend.utils.Result;
import edu.dev.backend.utils.ResultVOUtil;
import edu.dev.backend.utils.VO2EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create By  @林俊杰
 * 2022/3/31 9:51
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
@Controller
public class OpinionController {
    @Autowired
    private OpinionService opinionService;

    @PostMapping(value = "addOpinion")
    public Object addOpinion(@RequestBody Map<String, Object> form, HttpServletRequest request){
        System.out.println(form);
        Opinion params = new Opinion();
        params.setContent((String) form.get("content"));
        params.setPhone((String) form.get("phone"));
        params.setName((String) form.get("name"));
        params.setPolicyId((Integer) form.get("policy_id"));
        params.setCreateTime(new Date());
        Integer insert = opinionService.addOpinion(params);
        if (insert==1) return Result.success();
        return Result.errorMsg("发表意见失败");
    }

    @GetMapping(value = "getOpinionTableData")
    public Object getOpinionTableData(@RequestParam("policy_id") Integer policy_id, HttpServletRequest request){
        List<Opinion> opinions = opinionService.getOpinionListByPolicyId(policy_id);
        if (opinions==null) return Result.errorMsg("获取相关意见集失败");
        List<OpinionVO> data = VO2EntityUtil.opinions2OpinionVOs(opinions);
        return ResultVOUtil.success(data);
    }
}
