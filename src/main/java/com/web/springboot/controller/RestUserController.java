package com.web.springboot.controller;

import com.web.springboot.model.User;
import com.web.springboot.service.RoleService;
import com.web.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class RestUserController {

    private UserService userService;

    private RoleService roleService;

    public RestUserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public ResponseEntity getUsers(){
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping("/admin/roles")
    public ResponseEntity getRoles(){
        return new ResponseEntity<>(roleService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/admin/add")
    public void addUser(@RequestBody User user, @RequestParam(value = "role") String[] rolesName){
        userService.add(user, rolesName);
    }

    @DeleteMapping(value = "/admin/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.remove(id);
    }

    @PostMapping(value = "/admin/update")
    public void updateUser(@RequestBody User user, @RequestParam(value = "role", required = false) String[] rolesName){
        userService.update(user, rolesName);
    }

}
