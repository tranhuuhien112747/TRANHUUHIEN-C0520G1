package controllers;

import model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ImplSettingsRepository;
import repository.SettingsRepository;

import java.util.List;

@Controller
@RequestMapping({"", "electronic"})
public class ElectronicController {
    SettingsRepository repository = new ImplSettingsRepository();

    @RequestMapping(method = RequestMethod.GET)
    public String show(@ModelAttribute("settings") Settings settings, ModelMap modelMap) {
        List<String> languageList = repository.getLanguage();
        List<String> pageSizeList = repository.getPageSize();
        modelMap.addAttribute("languageList", languageList);
        modelMap.addAttribute("pageSizeList", pageSizeList);
        return "form";
    }

    @RequestMapping( value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("settings") Settings settings, ModelMap modelMap) {
        modelMap.addAttribute("languages", settings.getLanguages());
        modelMap.addAttribute("pageSize", settings.getPageSize());
        modelMap.addAttribute("spamsFilter", settings.getSpamsFilter());
        modelMap.addAttribute("signature", settings.getSignature());
        return "update";
    }
}
