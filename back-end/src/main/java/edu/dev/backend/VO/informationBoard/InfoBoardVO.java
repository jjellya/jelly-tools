package edu.dev.backend.VO.informationBoard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Create By  @林俊杰
 * 2022/3/27 22:16
 *
 * @version 1.0
 */
@Data
@Getter
@Setter
public class InfoBoardVO {
    @JsonProperty("infoDataList")
    private List<InfoDataVO> infoDataList;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("user")
    private Object user;
}
