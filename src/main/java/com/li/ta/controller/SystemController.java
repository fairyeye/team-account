package com.li.ta.controller;

import com.li.ta.common.utils.R;
import com.li.ta.entity.UserDetail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 系统管理相关接口
 *
 * @author baiye 2021/03/11 10:43 上午
 */
@RestController(value = "systemController")
@RequestMapping(value = "/system")
public class SystemController {

    private static final String ADMIN = "admin";
    private static final String PASSWD = "admin123";

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate template;

    @PostMapping(value = "/user/login")
    public R userLogin(@RequestBody UserDetail userDetail) {

        redisTemplate.opsForValue().set("key","test");
        System.out.println(template.opsForValue().get("zhp.test.today"));

        if (StringUtils.equals(userDetail.getUserName(), ADMIN)) {
            if (StringUtils.equals(userDetail.getPasswd(), PASSWD)) {
                return R.ok().put("token","adminToken").put("redis",redisTemplate.opsForValue().get("key"));
            }
        }

        return R.error(401, "请使用管理员账户登录。");
    }


}
