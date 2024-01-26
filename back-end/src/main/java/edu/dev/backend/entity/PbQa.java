package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description pb_qa
 * @author 林俊杰
 * @date 2022-03-30
 */
@Data
public class PbQa implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 类型:1.投诉/2.咨询/3.建议/4.不公开投诉/5.不公开咨询/6.不公开建议
     */
    private Integer type;

    /**
     * 证件号码
     */
    private String identicalCode;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 咨询标题
     */
    private String qTitle;

    /**
     * 咨询内容
     */
    private String qContent;

    /**
     * 答复内容
     */
    private String aContent;

    /**
     * 咨询时间
     */
    private Date qTime;

    /**
     * 答复时间
     */
    private Date aTime;

    /**
     * 问题归属地
     */
    private String region;

    /**
     * 答复部门id
     */
    private Integer deptId;

    /**
     * 咨询评分
     */
    private Integer score;

    public PbQa() {}
}
