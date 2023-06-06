package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rikkei.academy.DTO.SignUpDTO;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.IRoleService;
import rikkei.academy.service.IUserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @GetMapping("/register")
    public String showFormRegister(Model model) {
        SignUpDTO signUpDTO = new SignUpDTO();
        model.addAttribute("user", signUpDTO);
        return "user/register";
    }

    @PostMapping("/register")
    public String actionRegister(@Validated @ModelAttribute("user") SignUpDTO signUpDTO,
                                 BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/user/register";
        } else {
            if (userService.existsByUsername(signUpDTO.getUsername())) {
                model.addAttribute("validate", "Username can not be existed !");
                return "/user/register";
            }
            if (userService.existsByEmail(signUpDTO.getEmail())) {
                model.addAttribute("validate", "Email can not be existed !");
                return "/user/register";
            }
            String admin = "admin";
            Set<String> strRole = new HashSet<>();
            strRole.add(admin);
            Set<Role> roleSet = new HashSet<>();
            strRole.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByName(RoleName.ADMIN);
                        roleSet.add(adminRole);
                        break;
                    case "pm":
                        Role pmRole = roleService.findByName(RoleName.PM);
                        roleSet.add(pmRole);
                        break;
                    default:
                        Role userRole = roleService.findByName(RoleName.USER);
                        roleSet.add(userRole);
                }
            });
            User user = new User(signUpDTO.getEmail(), signUpDTO.getName(), signUpDTO.getPassword(), signUpDTO.getUsername(), roleSet);
            userService.save(user);
            redirectAttributes.addFlashAttribute("validate", "Create Success !");
            return "redirect:/";
        }
    }
}
