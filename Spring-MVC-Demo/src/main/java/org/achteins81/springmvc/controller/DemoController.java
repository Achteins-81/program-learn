package org.achteins81.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * demo页controller
 *
 * @author Achteins-81
 * @since 2023-04-13
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("")
    public String gotoDemo() {
        return "demo/demo";
    }
}
