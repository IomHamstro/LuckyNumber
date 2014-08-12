package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.Date;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Integer saveUser(@RequestBody  String user) {
return 4;
//        userSerrvice.saveUser(user);
//        return getNumber(user.getFirst(),user.getSecond(),user.getThird(),user.getBdate());

    }
//    public Integer saveTimeIn(String fio, Integer first, Integer second, Integer third) {
//        if(!fio.isEmpty()){
//            User user = new User();
//            user.setFio(fio);
//            user.setFirst(first);
//            user.setSecond(second);
//            user.setThird(third);
//            user.setLuckyNumber(getNumber());
////            user.setBdate(bdate);
//            userService.saveUser(user);
//            return user.getLuckyNumber();
//        }
//
//        return null;


    private Integer getNumber(Integer first, Integer second, Integer third, Date date) {
        return 5;
    }

    @RequestMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mv = new ModelAndView("lucky_number");
        mv.addObject("user", new User());
        return mv;
    }


//    @RequestMapping("/user/save")
//    public String saveUser(User user) {
//        userService.saveUser(user);
//        return "redirect:/cv/list";
//    }
////
//    @RequestMapping("/cv/search")
//    public @ResponseBody
//    List<CVVO> getCVs(@RequestParam String term) {
//        Iterable<CV> cvs = userService.getCVsByNamePart(term);
//        List<CVVO> result = new ArrayList<CVVO>();
//        for (CV cv:cvs) {
//            result.add(new CVVO(cv.getId(), cv.getTitle()));
//        }
//        return result;
//    }

}
