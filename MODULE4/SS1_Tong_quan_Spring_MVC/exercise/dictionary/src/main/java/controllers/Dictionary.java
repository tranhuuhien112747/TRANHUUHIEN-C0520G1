package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class Dictionary {

    @GetMapping(value = {"","/dictionary"})
    public String showWork() {
        return "dictionary";
    }

    @PostMapping
    public ModelAndView getMeaning(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        Map<String, String> dictionaryList = new TreeMap<>();
        dictionaryList.put("hello", "Xin Chao");
        dictionaryList.put("computer", "May Tinh");
        dictionaryList.put("action", "Hanh Dong");
        dictionaryList.put("How", "la ai?");
        dictionaryList.put("where", "o dau?");
        dictionaryList.put("when", "khi nao");
        String english = request.getParameter("english");
        String vietnam = null;
        String message = "Not Found";
        if (dictionaryList.get(english) == null) {
            modelAndView.addObject("message", message);
        } else {
            modelAndView.addObject("english", english);
            vietnam = dictionaryList.get(english);
            modelAndView.addObject("vietnam", vietnam);
        }
        return modelAndView;
    }

}
