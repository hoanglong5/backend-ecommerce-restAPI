package com.hoanglong.backendecommercerestapi.generates.genAPI;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RestResponse<T>  implements Serializable {
    private T data;
    private Date reponseDate;
    private boolean isSuccess;
    private String message;

    public RestResponse(T data, boolean isSuccess){
        this.data = data;
        this.isSuccess = isSuccess;
        reponseDate = new Date();
    }
    public RestResponse(T data, boolean isSuccess,String message){
        this.data = data;
        this.isSuccess = isSuccess;
        reponseDate = new Date();
        this.message = message;
    }

    public static <T> RestResponse<T> of(T t,String message){
        return new RestResponse<>(t,true,message);
    }

    public static <T> RestResponse<T> error(T t,String message){
        return new RestResponse<>(t, false,message);
    }

    public static <T> RestResponse<T> empty(){
        return new RestResponse<>(null, true);
    }
}
