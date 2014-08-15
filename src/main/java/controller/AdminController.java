package controller;

import model.Admin;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;
import service.UserService;
import viewobject.UserVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ольга on 12.08.2014.
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ModelAndView login(Admin admin) {
        Admin currentAdmin = adminService.findAdminByLogin(admin.getLogin());
        ModelAndView mv = new ModelAndView();
        if (currentAdmin == null || !currentAdmin.getPassword().equals(admin.getPassword())) {
            mv.setViewName("index");
            mv.addObject("noUser", new User());
        } else {
            mv.setViewName("admin_page");
            mv.addObject("users", userService.findAllUsers());
        }
        return mv;
    }

    @RequestMapping("/user/edit/{id}")
    public ModelAndView editCV(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("user_edit");
        User user = userService.getUserById(id);
        UserVO userVO = new UserVO(user.getFio(), user.getBdate().toString(), user.getFirst(), user.getSecond(), user.getThird());
        userVO.setId(user.getId());
        mv.addObject("userVO", userVO);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/update")
    public ModelAndView updateUser(UserVO userVO) {
        ModelAndView mv = new ModelAndView("admin_page");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(userVO.getBdate());
            User user = new User(userVO.getFio(), date, userVO.getFirst(), userVO.getSecond(), userVO.getThird());
            user.setId(userVO.getId());
            user.setLuckyNumber(MainController.getNumber(userVO.getFirst(), userVO.getSecond(), userVO.getThird(), date));
            userService.saveUser(user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mv.addObject("users", userService.findAllUsers());
        return mv;
    }
}
