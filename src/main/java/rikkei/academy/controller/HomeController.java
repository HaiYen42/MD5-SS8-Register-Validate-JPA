package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.DTO.SignUpDTO;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String showFormHome(Model model) {
        return "index";
    }


}
