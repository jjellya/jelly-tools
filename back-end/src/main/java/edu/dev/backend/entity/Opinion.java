package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/31 9:20
 *
 * @version 1.0
 */
@Data
public class Opinion implements Serializable {

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
     * 姓名或单位名称
     */
    private String name;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 意见内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    public Opinion() {}
}
