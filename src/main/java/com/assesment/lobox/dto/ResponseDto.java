package com.assesment.lobox.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private Object result;
    private String errors;
}
