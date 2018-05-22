package pl.workshop.crmworkshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.workshop.crmworkshop.entity.Role;
import pl.workshop.crmworkshop.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getOrCreate(String name) {

        Role role = roleRepository.findByName(name);

        if (role == null) {

            role = new Role();
            role.setName(name);

            role = roleRepository.save(role);
        }

        return role;
    }
}
