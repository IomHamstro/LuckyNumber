package controller;

import model.Admin;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public Integer saveUser(@RequestParam String fio, String bdate, Integer first, Integer second, Integer third) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(bdate);
            User user = new User(fio, date, first, second, third);
            user.setLuckyNumber(getNumber(first, second, third, date));
            userService.saveUser(user);
            return getNumber(first, second, third, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }



    public static Integer getNumber(Integer first, Integer second, Integer third, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Integer result = (first+second)*third - calendar.get(Calendar.DAY_OF_MONTH)*calendar.get(Calendar.MONTH)-calendar.get(Calendar.YEAR);
        if(result <0)
            result*=-1;
        return result;
    }

    @RequestMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("user", new User());
        mv.addObject("admin", new Admin());
        return mv;
    }


}
