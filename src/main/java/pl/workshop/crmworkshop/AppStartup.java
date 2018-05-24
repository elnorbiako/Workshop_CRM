package pl.workshop.crmworkshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.workshop.crmworkshop.entity.Role;
import pl.workshop.crmworkshop.entity.User;
import pl.workshop.crmworkshop.service.RoleService;
import pl.workshop.crmworkshop.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppStartup implements ApplicationRunner {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public AppStartup(UserService userService,
                      RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (userService.getNumUsers() == 0L) {
            userService.saveUser(testUser1());
            userService.saveUser(testUser2());
        }
    }

    private User testUser1() {
        User user = new User();
        user.setUsername("alice");
        user.setPassword("zxc123");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getOrCreate("USER"));
        user.setRoles(userRoles);

        return user;
    }

    private User testUser2() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getOrCreate("ADMIN"));
        user.setRoles(userRoles);
        return user;
    }
}
