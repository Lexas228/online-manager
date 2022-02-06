package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.*;
import ru.vsu.online.manager.repo.UserRepository;
import ru.vsu.online.manager.service.PurchaseHistoryService;
import ru.vsu.online.manager.service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PurchaseHistoryService purchaseHistoryService;

    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public List<User> getAllUsersWithRole(Long roleId) {
        return userRepository.getAllWithRoleId(roleId);
    }

    @Override
    public List<User> getAllUsersWithRole(String roleName) {
        return userRepository.getAllWithRoleName(roleName);
    }

    @Override
    public List<User> getAllUsersWithPrivilege(Long privilegeId) {
        return userRepository.getAllWithPrivilegeId(privilegeId);
    }

    @Override
    public List<User> getAllUsersWithPrivilege(String privilegeName) {
        return userRepository.getAllWithPrivilegeName(privilegeName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getByLogin(username);
        if(user != null){
            List<GrantedAuthority> grantedAuthorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            user.getRoles().forEach(role -> role.getPrivileges().stream().map(privilege -> new SimpleGrantedAuthority(privilege.getName())).forEach(grantedAuthorities::add));
            return new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
        }
        throw new UsernameNotFoundException("Username " + username + " was not found in database");
    }

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Role> getRolesByUserLogin(String login) {
        return null;
    }

    @Override
    public List<Privilege> getPrivilegesByRoleId(Long roleId) {
        return null;
    }

    @Override
    public List<Privilege> getPrivilegesByRoleName(String roleName) {
        return null;
    }

    @Override
    public boolean isHasByLogin(String login) {
        return getByLogin(login) != null;
    }

    @Override
    @Transactional
    public List<User> getAllWhichBuy(Long productId) {
        return purchaseHistoryService.getAllWhichBuy(productId).stream().map(PurchaseHistory::getUser).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllWhichBuy(ProductType productType) {
        return purchaseHistoryService.getAllWhichBuy(productType).stream().map(PurchaseHistory::getUser).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllWhichBuy(String productName) {
        return purchaseHistoryService.getAllWhichBuy(productName).stream().map(PurchaseHistory::getUser).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllWhichBuyInShopWithProductType(Long shopId, ProductType productType) {
        return purchaseHistoryService.getAllWhichBuyInShopWithProductType(shopId, productType).stream().map(PurchaseHistory::getUser).collect(Collectors.toList());
    }
}
