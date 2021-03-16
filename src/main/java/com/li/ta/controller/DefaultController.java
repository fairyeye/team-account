package com.li.ta.controller;

import com.li.ta.common.exception.CommonException;
import com.li.ta.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc
 *
 * @createTime li 2020年11月29日 21:14:00
 */
@RestController("defaultController")
@RequestMapping(value = "/")
public class DefaultController {

    @GetMapping
//    @Permission
    public R def() throws CommonException {
      throw new CommonException();
//      return R.ok().put("200", "This is default result.");
    }

}
