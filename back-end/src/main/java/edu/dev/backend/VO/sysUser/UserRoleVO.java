package edu.dev.backend.VO.sysUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Create By  @林俊杰
 * 2022/3/28 18:06
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class UserRoleVO {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("userRole")
    private Integer userRole;
}
