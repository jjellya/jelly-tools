package edu.dev.backend.VO.opinion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/31 11:09
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class OpinionVO {
    @JsonProperty("policy_id")
    private Integer policy_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("content")
    private String content;

    @JsonProperty("date")
    private Date date;
}
