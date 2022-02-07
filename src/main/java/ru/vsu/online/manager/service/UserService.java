package ru.vsu.online.manager.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.*;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    User findById(Long id);
    User getByLogin(String login);
    boolean isHasByLogin(String login);
    List<User> getAllUsersWithRole(Long roleId);
    List<User> getAllUsersWithRole(String roleName);
    List<User> getAllUsersWithPrivilege(Long privilegeId);
    List<User> getAllUsersWithPrivilege(String privilegeName);
    List<Role> getRolesByUserId(Long userId);
    List<Role> getRolesByUserLogin(String login);
    List<User> getAllWhichBuy(Long productId);
    List<User> getAllWhichBuyByProductTypeName(String productTypeName);
    List<User> getAllWhichBuy(String productName);
    List<User> getAllWhichBuyInShopWithProductType(Long shopId, String productTypeName);
    void save(User user);
}
