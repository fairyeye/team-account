package com.li.ta.aspect;

import com.li.ta.common.exception.CommonException;
import com.li.ta.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * desc
 *
 * @author zh 2021/01/08 10:02 上午
 */
@RestControllerAdvice(basePackages = "com.li.ta.controller")
public class ExceptionAspect {

    private static Logger log = LoggerFactory.getLogger(ExceptionAspect.class);

    @ResponseBody
    @ExceptionHandler(value= Exception.class)
    public R handleValidException(Exception e) {
        Throwable cause = e.getCause();
        return R.error(100000, "出现了了意料之外的错误。");
    }


//    @ResponseBody
//    @ExceptionHandler(value= BadSqlGrammarException.class)
//    public R handleValidException(BadSqlGrammarException e) {
//        return R.error(100001, "数据操作错误");
//    }

    @ResponseBody
    @ExceptionHandler(value= NullPointerException.class)
    public R handleValidException(NullPointerException e) {
        return R.error(100002, "空指针异常！");
    }

    @ResponseBody
    @ExceptionHandler(value= CommonException.class)
    public R handleValidException(CommonException e) {
        log.info("请登录！");
        return R.error(100003, "请登录！");
    }
}
