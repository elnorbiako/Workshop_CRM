package pl.workshop.crmworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.workshop.crmworkshop.entity.Activity;
import pl.workshop.crmworkshop.entity.Project;
import pl.workshop.crmworkshop.repository.ProjectRepository;
import pl.workshop.crmworkshop.service.ActivityService;
import pl.workshop.crmworkshop.service.ProjectService;
import pl.workshop.crmworkshop.service.UserService;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;
    private final ProjectService projectService;
    private final ActivityService activityService;



    @Autowired
    public HomeController(UserService userService,
                          ProjectService projectService,
                          ActivityService activityService) {
        this.userService = userService;
        this.projectService = projectService;
        this.activityService = activityService;
    }


    @GetMapping("/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersView";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Project> projects = projectService.findTop5ByOrderByCreatedDesc();
        List<Activity> activities = activityService.findTop25ByOrderByTimeDesc();
        model.addAttribute("projects", projects);
        model.addAttribute("activities", activities);

        return "Home";
    }
}
