package com.arnold.web.CustomView;

import com.arnold.web._domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/customView")
public class CustomViewController {

    @RequestMapping(value = "/showUserListByFtl")
    public String showUserListInFtl(ModelMap mm) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆");
        calendar.set(1980, 1, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListFtl";
    }


    @RequestMapping(value = "/showUserListByXml")
    public String showUserListInXml(ModelMap mm) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("222");
        calendar.set(1980, 1, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰 ");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListXml";
    }


    @RequestMapping(value = "/showUserListByXls")
    public String showUserListInExcel(ModelMap mm) {
        Calendar calendar = new GregorianCalendar();

        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("tom2");
        calendar.set(1980, 1, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("john2");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListExcel";
    }

    @RequestMapping(value = "/showUserListMix")
    public String showUserListMix(ModelMap mm) {
        Calendar calendar = new GregorianCalendar();
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("tom");
        user1.setRealName("汤姆1");
        calendar.set(1980, 1, 1);
        user1.setBirthday(calendar.getTime());
        User user2 = new User();
        user2.setUserName("john");
        user2.setRealName("约翰");
        user2.setBirthday(calendar.getTime());
        userList.add(user1);
        userList.add(user2);
        mm.addAttribute("userList", userList);
        return "userListMix";
    }
}
