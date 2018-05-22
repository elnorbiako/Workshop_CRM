package pl.workshop.crmworkshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.workshop.crmworkshop.entity.User;
import pl.workshop.crmworkshop.service.UserService;

@Component
public class AppStartup implements ApplicationRunner {

    private final UserService userService;

    @Autowired
    public AppStartup(UserService userService) {
        this.userService = userService;
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
        return user;
    }

    private User testUser2() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        return user;
    }
}
