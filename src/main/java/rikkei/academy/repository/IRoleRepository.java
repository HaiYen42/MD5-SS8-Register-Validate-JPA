package rikkei.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
