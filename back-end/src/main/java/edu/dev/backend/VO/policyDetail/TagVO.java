package edu.dev.backend.VO.policyDetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Create By  @林俊杰
 * 2022/3/19 20:31
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class TagVO {
    @JsonProperty("tag_id")
    private Integer tag_id;

    @JsonProperty("tag_content")
    private String tag_content;


}
