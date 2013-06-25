/**
 * @(#)UserController.java, 2013-6-24. 
 * 
 */
package com.cloudstone.emenu.ctrl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xuhongfeng
 *
 */
@Controller
public class UserController extends BaseWebController {
    
    @RequestMapping(value={"/user", "/admin"})
    public String get() {
        return "user";
    }

}
