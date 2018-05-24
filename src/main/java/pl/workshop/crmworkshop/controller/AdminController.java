package pl.workshop.crmworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.workshop.crmworkshop.entity.Role;
import pl.workshop.crmworkshop.entity.User;
import pl.workshop.crmworkshop.service.ProjectService;
import pl.workshop.crmworkshop.service.RoleService;
import pl.workshop.crmworkshop.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ProjectService projectService;




    @Autowired
    public AdminController(UserService userService,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }




    @GetMapping("/admin/addAdmin")
    public String adminForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/AdminForm";
    }

    @PostMapping("/admin/addAdmin")
    public String adminForm(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/addAdmin";
        }
        User adminDb = new User();

        adminDb.setUsername(user.getUsername());
        adminDb.setFirstName(user.getFirstName());
        adminDb.setLastName(user.getLastName());
        adminDb.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        adminDb.setEnabled(true);

        userService.saveAdmin(adminDb);
        return "redirect:/home";
    }

    @GetMapping("/admin/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/UsersView";
    }

    @GetMapping("/admin/projects")
    public String showAllProjects(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "admin/ProjectsView";
    }

}
