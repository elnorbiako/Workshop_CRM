package pl.workshop.crmworkshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.workshop.crmworkshop.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
