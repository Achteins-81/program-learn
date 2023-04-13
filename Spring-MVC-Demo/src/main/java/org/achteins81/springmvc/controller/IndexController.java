package org.achteins81.springmvc.controller;

import org.achteins81.springmvc.response.AjaxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页
 *
 * @author Achteins-81
 * @since 2023-04-12
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    /**
     * 一个接收AJAX请求并返回响应结果信息的方法
     *
     * @param request 请求
     * @return 响应结果
     * @author Achteins-81
     * @since 2023-04-12
     */
    @RequestMapping("/getMessage")
    @ResponseBody
    public AjaxResponse getMessage(HttpServletRequest request) {
        String date = request.getParameter("time");
        Map<String, Object> data = new HashMap<>(16);
        data.put("msg", String.format("This is a Spring MVC Demo.%n Your request send time is: %s", date));
        AjaxResponse result = new AjaxResponse();
        result.setData(data);
        return result;
    }
}
