package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/31 9:21
 *
 * @version 1.0
 */
@Data
public class OpinionCollection implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 归属于哪个意见征集说明文id
     */
    private Integer policyId;

    /**
     * 关于意见采纳结果的反馈
     */
    private String result;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 截至时间
     */
    private Date updateTime;

    /**
     * 答复部门id
     */
    private Integer deptId;

    public OpinionCollection() {}
}
