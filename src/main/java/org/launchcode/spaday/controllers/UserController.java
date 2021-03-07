package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (verify.equals(user.getPassword()) && !verify.equals("") && !user.getUsername().equals("") && !user.getEmail().equals("")) {
            model.addAttribute("user", user);
            UserData.add(user);
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords must match!");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "user/add";
        }
    }

    @GetMapping({"details/{userId}"})
    public String displayUserInfo(Model model, @PathVariable int userId) {
        User user = UserData.getById(userId);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/details";
    }



}
