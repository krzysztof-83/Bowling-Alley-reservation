package pl.christopherk.BowlingAlley.controller;

import org.springframework.web.bind.annotation.*;
import pl.christopherk.BowlingAlley.common.dto.UserDto;
import pl.christopherk.BowlingAlley.service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<UserDto> getUsers(){
        return userService.findAllUsers();
    }

    @RequestMapping(value = "/{email}")
    public UserDto getUserByEmail(@PathVariable("email") String email){
        return userService.findUserByEmail(email);
    }


}
