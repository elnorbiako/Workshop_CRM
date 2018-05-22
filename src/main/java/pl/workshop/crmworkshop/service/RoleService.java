package pl.workshop.crmworkshop.service;


import org.springframework.stereotype.Service;
import pl.workshop.crmworkshop.entity.Role;


public interface RoleService {

    Role getOrCreate(String roleName);
}
