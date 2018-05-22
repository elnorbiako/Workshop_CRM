package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workshop.crmworkshop.entity.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);


    List<User> findAllByProjectsId(Long projectId);

}
