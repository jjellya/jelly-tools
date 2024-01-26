package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Create By  @林俊杰
 * 2022/3/15 20:18
 *
 * @version 1.0
 */
@Data
public class PbLeader implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 领导名字
     */
    private String name;

    /**
     * 职务
     */
    private String position;

    /**
     * 简历
     */
    private String cv;

    public PbLeader() {}
}
