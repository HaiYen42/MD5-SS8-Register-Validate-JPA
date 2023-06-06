package rikkei.academy.service;

import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;

public interface IRoleService {
    Role findByName(RoleName name);
}
