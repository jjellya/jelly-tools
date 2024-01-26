package edu.dev.backend.VO.policyDetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/19 20:27
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class PolicyVO {

    @JsonProperty("text_content")
    private String text_content;

    @JsonProperty("introduce_visible")
    private boolean introduce_visible;

    @JsonProperty("post_tags")
    private List<TagVO> post_tags;

    @JsonProperty("policy_id")
    private Integer policy_id;

    @JsonProperty("location")
    private String location;

    @JsonProperty("text_title")
    private String text_title;

    @JsonProperty("post_type")
    private Integer post_type;

    @JsonProperty("post_agency")
    private String post_agency;

    @JsonProperty("issue_number")
    private String issue_number;

    @JsonProperty("create_date")
    private Date create_date;

    @JsonProperty("release_date")
    private Date release_date;

    @JsonProperty("validity")
    private boolean validity;


}
