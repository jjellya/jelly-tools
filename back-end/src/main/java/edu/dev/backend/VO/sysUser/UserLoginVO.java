package edu.dev.backend.VO.sysUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.dev.backend.VO.policyDetail.TagVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/28 16:32
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class UserLoginVO {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("token")
    private String token;

}
