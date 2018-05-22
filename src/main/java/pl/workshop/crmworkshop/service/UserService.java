package pl.workshop.crmworkshop.service;



import pl.workshop.crmworkshop.entity.User;

import java.util.List;

public interface UserService {

    long getNumUsers();

    List<User> findAll();

    User findByUserName(String name);

    void saveUser(User user);
    
    List<User> findAllByProjectId(Long projectId);
}
