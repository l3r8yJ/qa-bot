package ru.volpi.qabot.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.volpi.qabot.service.impl.RestService;

@Controller
@RequiredArgsConstructor
public class AdminPanelController {

    private final RestService restService;

    @GetMapping("/admin")
    public String index(final Model model) {
        model.addAttribute("categories", this.restService.allCategories());
        return "admin";
    }
}
