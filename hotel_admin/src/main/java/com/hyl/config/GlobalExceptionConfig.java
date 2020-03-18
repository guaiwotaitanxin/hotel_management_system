package com.hyl.config;

import com.hyl.common.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 韩宇龙
 * @create 2020-03-17 20:19
 *   统一异常处理  利用AOP思想
 */
@ControllerAdvice
public class GlobalExceptionConfig {
    //  对所有异常进行处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("出现了异常");
    }

}
