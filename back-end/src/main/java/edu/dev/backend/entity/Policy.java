package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/15 20:19
 *
 * @version 1.0
 */
@Data
public class Policy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文件标题
     */
    private String title;

    /**
     * 发布机构
     */
    private Integer author;

    /**
     * 发文字号
     */
    private String code;

    /**
     * 成文时间
     */
    private Date createTime;

    /**
     * 发布时间
     */
    private Date updateTime;

    /**
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private Integer type;

    public Policy() {}
}
