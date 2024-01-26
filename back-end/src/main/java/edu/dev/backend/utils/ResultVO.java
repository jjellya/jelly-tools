package edu.dev.backend.utils;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;

    public ResultVO(Integer status,
                    String msg,
                    T data){
        this.code = status;
        this.message = msg;
        this.data = data;
    }
}
