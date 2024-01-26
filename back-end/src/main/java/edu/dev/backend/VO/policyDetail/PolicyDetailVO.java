package edu.dev.backend.VO.policyDetail;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Create By  @林俊杰
 * 2022/3/29 15:31
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class PolicyDetailVO {
    @JsonProperty("policy")
    private Object policy;

    @JsonProperty("user")
    private Object user;
}
