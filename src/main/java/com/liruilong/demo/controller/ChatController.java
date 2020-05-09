package com.liruilong.demo.controller;


import com.liruilong.demo.service.HrService;
import com.liruilong.model.Hr;
import com.liruilong.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;

    /**
     * @Author Liruilong
     * @Description  模拟数据,获取所有的好友
     * @Date 18:24 2020/2/11
     * @Param []
     * @return java.util.List<com.liruilong.model.Hr>
     **/

    @GetMapping("/hrs")
    public List<Hr> getAllHrs(Authentication authentication) {
        List<Hr> list = new ArrayList<>();
        return hrService.getAllHrs(authentication);
    }

    @GetMapping("/")
    public Object selectUser(@RequestParam(defaultValue = "null") String name){
        Hr hr = (Hr) hrService.getHr(name);

        return hr!= null?hr: RespBean.error("用户名不存在!");
    }
}
