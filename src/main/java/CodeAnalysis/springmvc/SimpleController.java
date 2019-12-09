package CodeAnalysis.springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-29 19:48
 */
public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("userView");
        modelAndView.addObject("name","ccsu-xp");
        return modelAndView;
    }
}
