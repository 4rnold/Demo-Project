package com.arnold.web.XmlAndJsonRequest.controller;

import com.arnold.web.XmlAndJsonRequest.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class XmlController {

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "hello";
    }

    /**
     * 获取xml或json
     * @param requestEntity
     * @return
     */
    @RequestMapping(value = "/handle13")
    public ResponseEntity<User> handle13(HttpEntity<User> requestEntity) {
        User user = requestEntity.getBody();
        user.setUserId("1000");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/handle14")
    @ResponseBody
    public User handle14(@RequestBody User user) {
        //User user = requestEntity.getBody();
        user.setUserId("1000");
        return user;
    }


    /**
     * 使用form提交 user才能获取到数据，xml如何直接获取数据到user。
     * @param user
     * @param bindingResult
     * @param mm
     * @return
     */
    @RequestMapping(value = "/handle91")
    @ResponseBody
    public User handle91(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap mm) {
        if (bindingResult.hasErrors()) {
            return user;
        } else {
            return user;
        }
    }
}
