package com.teamtwentyfour.fooddeliverysaas.exception;

import com.teamtwentyfour.fooddeliverysaas.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(BaseException ex, HttpServletRequest request) {
        return new ErrorDto(ex.getMessage(), 10000L, request.getRequestURL().toString());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Exception ex, HttpServletRequest request) {
        return new ErrorDto(ex.getMessage(), 90000L, request.getRequestURL().toString());
    }

}
