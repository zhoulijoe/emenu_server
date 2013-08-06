/**
 * @(#)TestController.java, Aug 4, 2013. 
 * 
 */
package com.cloudstone.emenu.ctrl.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudstone.emenu.data.Bill;
import com.cloudstone.emenu.data.User;
import com.cloudstone.emenu.logic.OrderLogic;
import com.cloudstone.emenu.logic.UserLogic;
import com.cloudstone.emenu.util.JsonUtils;

/**
 * 
 * just for test
 * 
 * @author xuhongfeng
 *
 */
@Controller
public class TestController extends BaseApiController {
    @Autowired
    private UserLogic userLogic;

    @RequestMapping(value="/api/test", method=RequestMethod.GET)
    public @ResponseBody String test(HttpServletRequest req) {
        User user = userLogic.getUser(1);
        return JsonUtils.toJson(user);
    }
    
    @RequestMapping(value="/api/testdb", method=RequestMethod.GET)
    public @ResponseBody Bill testPayBill(HttpServletRequest req) {
        Bill bill = new Bill();
        return orderLogic.payBill(bill);
    }
}
