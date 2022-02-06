package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.online.manager.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByLogin(String login);

    @Query("select u from User u where exists(select r from u.roles r where r.id = :roleId)")
    List<User> getAllWithRoleId(@Param(value = "roleId") Long roleId);

    @Query("select u from User u where exists(select r from u.roles r where r.name = :roleName)")
    List<User> getAllWithRoleName(@Param(value = "roleName") String roleName);

    @Query("select u from User u where exists(select r from u.roles r where exists (select p from r.privileges p where p.id=:privId))")
    List<User> getAllWithPrivilegeId(@Param(value = "privId") Long privId);

    @Query("select u from User u where exists(select r from u.roles r where exists (select p from r.privileges p where p.name=:privName))")
    List<User> getAllWithPrivilegeName(@Param(value = "privName") String privName);
}
