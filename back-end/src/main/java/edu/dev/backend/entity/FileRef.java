package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * Create By  @林俊杰
 * 2022/3/15 20:29
 *
 * @version 1.0
 */
@Data
public class FileRef implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 文件id
     */
    private Integer fileId;

    public FileRef() {}
}
