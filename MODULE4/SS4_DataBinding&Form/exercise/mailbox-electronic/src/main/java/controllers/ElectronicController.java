package controllers;

import model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ImplSettingsRepository;

import java.util.List;

@Controller
@RequestMapping({"", "electronic"})
public class ElectronicController {
    @RequestMapping(method = RequestMethod.GET)
    public String show(@ModelAttribute("settings") Settings settings, ModelMap modelMap) {
        List<String> languageList= ImplSettingsRepository.
    }
}
