package com.farij.belajarAPI.Belajar.RestFull.API.response;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseGenerator<T> {

    public <T> CommonResponse<T> successResponse(T datas, String message){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setDatas(datas);
        commonResponse.setMessage(message);

        return commonResponse;
    }

    public <T> CommonResponse<T> failedResponse(String message){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("500");
        commonResponse.setMessage(message);
        return commonResponse;
    }

}
