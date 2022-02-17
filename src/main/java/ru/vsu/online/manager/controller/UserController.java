package ru.vsu.online.manager.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.online.manager.dto.UserDto;
import ru.vsu.online.manager.entity.User;
import ru.vsu.online.manager.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable Long id){
        User user = userService.findById(id);
        UserDto userDto = new UserDto();
        userDto.setName(user.getLogin());
        userDto.setSurname("Noname");
        return userDto;
    }
}
