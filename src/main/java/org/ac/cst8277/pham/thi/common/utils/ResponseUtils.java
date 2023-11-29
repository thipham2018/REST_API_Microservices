package org.ac.cst8277.pham.thi.common.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseUtils<T> {
    private String code;
    private Boolean status;
    private T data;
    private String message;

    public static <T> ResponseUtils<T> of(HttpStatus code, Boolean status, String message, T data){
        ResponseUtils<T> res = new ResponseUtils<>();
        res.setCode(String.valueOf(code.value()));
        res.status = status;
        res.data = data;
        res.message = message;
        return res;
    }
}
