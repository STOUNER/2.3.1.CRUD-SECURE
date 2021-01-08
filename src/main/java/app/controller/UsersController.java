package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String getHello() {
        return "listofpeople";
    }

    @GetMapping("/user-create")
    public String addPeople(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/users")
    public String getAllPeople(Model model) {
        List<User> resultList = userService.getAllUser();
        model.addAttribute("listUser", resultList);
        return "listofpeople";
    }

    @GetMapping("/delete-user")
    public String deleteUserById(Model model, @RequestParam(name = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-edit")
    public String userEdit(Model model, @RequestParam(name = "id") Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/user-save")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
