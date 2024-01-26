package edu.dev.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/15 20:27
 *
 * @version 1.0
 */
@Data
public class PbInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名或名称
     */
    private String name;

    /**
     * 公民/企业
     */
    private Integer type;

    /**
     * 工作单位
     */
    private String workplace;

    /**
     * 证件类型
     */
    private Integer identicalType;

    /**
     * 证件号码
     */
    private String identicalCode;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 政府信息公开义务机关( 机构id ）
     */
    private Integer deptId;

    /**
     * 所需信息的内容描述(名称、文号或其他特征描述)
     */
    private String content;

    /**
     * 获取政府信息的方式:1.邮寄;2.当面领取;3.现场查阅;4.电子邮件;5.传真
     */
    private Integer accessway;

    /**
     * 政府信息的载体形式:1.纸质;2.数据电文;
     */
    private Integer accesstype;

    /**
     * 申请时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 回复
     */
    private String reply;

    public PbInfo() {}
}
