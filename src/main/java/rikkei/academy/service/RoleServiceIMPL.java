package rikkei.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.repository.IRoleRepository;

@Service
public class RoleServiceIMPL implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Role findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
