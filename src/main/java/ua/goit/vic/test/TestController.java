package ua.goit.vic.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping("/templates/test")
    public ModelAndView testPage(){
        ModelAndView result = new ModelAndView("templates/test/testPage");
        result.addObject("testPage", "Hello, World!");
        return result;
    }
}
