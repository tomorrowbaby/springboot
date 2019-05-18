package com.example.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：统一异常类
 * @author wangyu
 * @date 2019/5/17
 */

@ControllerAdvice(basePackages = "com.example.demo")
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest request ,
                                         Exception e) throws Exception {
        ErrorInfo errorInfo = new ErrorInfo() ;
        errorInfo.setMessage(e.getMessage()) ;
        errorInfo.setUrl(request.getRequestURI()) ;
        errorInfo.setCode(ErrorInfo.ERROR) ;
        return errorInfo ;
    }
}
