package com.example.demo.controller;

import com.example.demo.exception.AppException;
import com.example.demo.exception.AppExceptionCodeMsg;
import com.example.demo.response.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {


    @GetMapping("demo")
    public Resp<String> demo1(String name) {

        if ("ok".equals(name)) {
            return Resp.success("succ");
        }
        if ("err".equals(name)) {
            //抛业务相关的异常
            throw new AppException(AppExceptionCodeMsg.USERNAME_NOT_EXISTS);
        }

        if ("errcode".equals(name)) {
            throw new AppException(AppExceptionCodeMsg.INVALID_CODE);
        }
        if ("0".equals(name)) {
            int i = 1 / 0;
        }

        //检查用户积分是否足够，如果不够，就抛出异常
        if ("notenough".equals(name)) {
            throw new AppException(AppExceptionCodeMsg.USER_CREDIT_NOT_ENOUGH);
        }

        return Resp.success("default");
    }

    @GetMapping("list")
    public Resp<List> list() {
        // 现在是dev分支提交
        // 现在是dev分支提交222
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu");
        return Resp.success(list);
    }
}
