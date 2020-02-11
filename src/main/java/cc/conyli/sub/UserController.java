package cc.conyli.sub;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @RequestMapping("/user/register")
    public String register() {
        System.out.println("register方法工作了");
        return "user/register";
    }

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(path = "/user",method = RequestMethod.POST)
    public ModelAndView createUser(User user) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/createSuccess");
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
