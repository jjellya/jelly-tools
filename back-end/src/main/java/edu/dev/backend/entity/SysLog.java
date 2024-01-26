package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description log
 * @author 林俊杰
 * @date 2022-03-30
 */
@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 事项标题
     */
    private String title;

    /**
     * 事项类型:依申请公开、建议、意见、投诉
     */
    private Integer type;

    /**
     * 事项外键id，有pb_info和pb_qa的id
     */
    private Integer pbId;

    /**
     * 申请人的id
     */
    private Integer userId;

    /**
     * 答复部门的id
     */
    private Integer deptId;

    /**
     * 未处理:0，登记:1，补正:2，拟办:3，征求第三方意见:4，审核:5，答复:6，存档:7
     */
    private Integer step;

    /**
     * 第三方意见
     */
    private String advice;

    /**
     * 申请人是否已确认
     */
    private Integer affirm;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public SysLog() {}
}
