package com.liruilong.demo.controller;


import com.liruilong.demo.service.HrService;
import com.liruilong.model.Hr;
import com.liruilong.model.RespBean;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Description :
 * @Author: Liruilong
 * @Date: 2020/2/11 18:00
 */

@RequestMapping("/login")
@RestController
public class Usercontroller {
    
    @Autowired
    HrService hrService;        

      Logger logger = Logger.getLogger("com.liruilong.demo.controller.Usercontroller");
    /**
     * @Author Liruilong
     * @Description  获取验证码
     * @Date 19:08 2020/2/11
     * @Param [request, response]
     * @return java.util.Map
     **/

    @GetMapping("/auth/code")
    public Map getCode(HttpServletRequest request, HttpServletResponse response) {
        // 算术类型 https://gitee.com/whvse/EasyCaptcha
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        // 几位数运算，默认是两位
        captcha.setLen(2);
        // 获取运算的结果
        String result = captcha.text();
        logger.info("生成的验证码：" + result +"       SessionId： "+request.getSession().getId());
        // 保存
        // 验证码信息
        Map<String, Object> imgResult = new HashMap<String, Object>(2) {{
            put("img", captcha.toBase64());

        }};
        request.getSession().setAttribute("code", result);
        logger.info(request.getSession().getId());
        return imgResult;
    }
    @GetMapping("/auth/img")
    public Object getUserfase(@RequestParam(defaultValue = "null") String username){
       Hr hr = (Hr) hrService.getUserfase(username);
        return hr!= null?hr:RespBean.error("用户名不存在!");
    }



}
