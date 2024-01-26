package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Create By  @林俊杰
 * 2022/3/15 20:28
 *
 * @version 1.0
 */
@Data
public class PbFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文件地址
     */
    private String url;

    public PbFile() {}
}
