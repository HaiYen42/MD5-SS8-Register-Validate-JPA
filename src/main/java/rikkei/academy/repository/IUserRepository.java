package rikkei.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.User;

//JpaRepository : trả về list thao tác dễ hơn
// PagingAndSortingRepository ---> trả về Iterable --> thao tác khó hơn
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
