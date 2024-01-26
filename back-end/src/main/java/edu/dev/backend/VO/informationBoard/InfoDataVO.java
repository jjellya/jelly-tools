package edu.dev.backend.VO.informationBoard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Create By  @林俊杰
 * 2022/3/27 20:43
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class InfoDataVO {
    @JsonProperty("policy_id")
    private Integer policy_id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("date")
    private Date date;
}
