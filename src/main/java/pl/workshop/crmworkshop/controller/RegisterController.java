package pl.workshop.crmworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.workshop.crmworkshop.entity.Activity;
import pl.workshop.crmworkshop.entity.Project;
import pl.workshop.crmworkshop.entity.Role;
import pl.workshop.crmworkshop.entity.User;
import pl.workshop.crmworkshop.service.ActivityService;
import pl.workshop.crmworkshop.service.ProjectService;
import pl.workshop.crmworkshop.service.RoleService;
import pl.workshop.crmworkshop.service.UserService;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class RegisterController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;




    @Autowired
    public RegisterController(UserService userService,
                              BCryptPasswordEncoder bCryptPasswordEncoder,
                              RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }




    @GetMapping("/register")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "user/UserForm";
    }

    @PostMapping("/register")
    public String userForm(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/UserForm";
        }
        User userDb = new User();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getOrCreate("ADMIN"));
        userDb.setRoles(userRoles);

        userDb.setUsername(user.getUsername());
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDb.setEnabled(true);

        userService.saveUser(user);
        return "redirect:/home";
    }

}
