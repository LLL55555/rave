package com.cola.zhongdian.controller;


import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.AjaxResult;

import java.util.Map;

@RestController("/request")
public class TestRequestController {

    @GetMapping("/test01")
    public Object test01(@RequestParam String id) {
        return id;
    }
    @GetMapping("/test02")
    public Object test02(@RequestBody String id) {
        return id;
    }

    @PostMapping("/test03")
    public AjaxResult test03(@RequestParam String id) {
        return AjaxResult.success(id);
    }

    @PostMapping("/test04")
    public AjaxResult test04(@RequestBody Object id) {
        return AjaxResult.success(id);
    }


    @PostMapping("/test05")
    public AjaxResult test05(@RequestBody Map<String,Object> map) {
        return AjaxResult.success(map);
    }
}
