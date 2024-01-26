package edu.dev.backend.controller;


import edu.dev.backend.entity.PbInfo;
import edu.dev.backend.service.PbInfoService;
import edu.dev.backend.utils.DateFormatUtil;
import edu.dev.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 依申请公开登记表 前端控制器
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
@Controller
public class PbInfoController {

    @Autowired
    private PbInfoService pbInfoService;

    @PostMapping(value = "applyForPublic")
    public Object applyForPublic(@RequestBody Map<String, Object> form, HttpServletRequest request){
        System.out.println(form);
        PbInfo applyForm = new PbInfo();
        applyForm.setName(form.get("name").toString());
        applyForm.setWorkplace((String) form.get("workplace"));
        applyForm.setIdenticalType((Integer) form.get("identicalType"));
        applyForm.setIdenticalCode((String) form.get("identicalCode"));
        applyForm.setPhone((String) form.get("phone"));
        applyForm.setPostalCode((String) form.get("postalCode"));
        applyForm.setAddress((String) form.get("address"));
        applyForm.setEmail((String) form.get("email"));
        applyForm.setDeptId((Integer)form.get("deptId"));
        applyForm.setContent((String) form.get("content"));
        applyForm.setAccessway((Integer)form.get("accessWay"));
        applyForm.setAccesstype((Integer) form.get("accessType"));
        Date date = null;
        try {
            date = DateFormatUtil.DATE_FORMAT.get().parse((String) form.get("date"));
        }catch (Exception e){
            System.out.println("时间转换失败！");
        }
        applyForm.setCreateTime(date);
//        String name = form.get("name").toString();//姓名
//        String workplace = (String) form.get("workplace");//工作单位
//        Integer identicalType = Integer.valueOf((String) form.get("identicalType"));//证件类型
//        String identicalCode = (String) form.get("identicalCode");//证件号码
//        String phone = (String) form.get("phone");//电话号码
//        String postalCode = (String) form.get("postalCode");//邮政编码
//        String address = (String) form.get("address");//联系地址
//        String email = (String) form.get("email");//电子邮箱
//        Integer deptId = Integer.valueOf((String) form.get("deptId"));//部门ID
//        String content = (String) form.get("content");//所需信息的内容描述
//        Integer accessWay = Integer.valueOf((String) form.get("accessWay"));//获取政府信息的方式
//        Integer accessType = Integer.valueOf((String) form.get("accessType"));//政府信息的载体形式
//        Date date = (Date)form.get("date");//申请时间
        return pbInfoService.addPbInfo(applyForm);
    }
}

