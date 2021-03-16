package com.li.ta.aspect;


import com.li.ta.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author baiye 2021/01/07 8:27 下午
 * @description
 */
@Aspect
@Component
public class PermissionAspect {

    @Pointcut("@annotation(com.li.ta.annotation.Permission)")
    public void apiPointcut() {
    }

    @Around("apiPointcut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();

        HashMap<String, String> map = new HashMap<>();

        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();

            String value = request.getHeader(name);

            map.put(name, value);
        }

        if (map.containsKey("authorization")) {

            Optional.ofNullable(map.get("authorization")).orElseThrow(() -> new Exception("授权失败！\t No Token"));

            Optional.ofNullable(JwtUtil.getUserId(map.get("authorization"))).orElseThrow(() -> new Exception("授权失败！\t No Token"));

        } else if (StringUtils.isEmpty(JwtUtil.getUserId(map.get("authorization")))){
            throw new Exception("授权失败！\t No Authorization" );
        }

        Object proceed = point.proceed();
    }
}
