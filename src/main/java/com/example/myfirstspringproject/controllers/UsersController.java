package com.example.myfirstspringproject.controllers;



import com.example.myfirstspringproject.dto.UserDto;
import com.example.myfirstspringproject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{user-id}")
    public String getConcreteUserPage(@PathVariable("user-id") Long userId, Model model) {
        UserDto user = usersService.getConcreteUser(userId);
        model.addAttribute("user", user);
        return "user_page";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getUsersPage(Model model)  {

            List<UserDto> users = usersService.getUsers();
            model.addAttribute("users", users);
            return "users_page";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<UserDto> searchUsers(@RequestParam("name") String username) {
        return usersService.search(username);
    }

}
