package com.example.dashboardbe.controllers;


import com.example.dashboardbe.Domaine.USER_ROLES;
import com.example.dashboardbe.Domaine.USER_DETAILS;
import com.example.dashboardbe.Exception.ResourceNotFoundException;
import com.example.dashboardbe.Repository.RoleRepository;
import com.example.dashboardbe.Repository.UserRepository;
import com.example.dashboardbe.Service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;
import java.util.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api/info")
@Slf4j
public class CRUDController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;
    //-------------------------------------CRUD----------------------------------//

    //--------------------
    @GetMapping
    public ResponseEntity<List<USER_DETAILS>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }
    @PostMapping("/{username}/addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@PathVariable String username, @RequestBody RoleDTO request) throws RoleNotFoundException {
        USER_DETAILS userEntity = userService.addRoleToUser(username, request.getRoleName());
        return ResponseEntity.ok(userEntity);
    }
    //--------------affiche tout les users------
    @GetMapping("/users")
    public List<USER_DETAILS> getAllUsers() {
        return userRepository.findAll();
    }

    //------------ affiche user par id----------

    @GetMapping("/users/{id}")
    public USER_DETAILS getUserInfo(@PathVariable("id") Long userId) {
        Optional<USER_DETAILS> optional = userRepository.findById(userId);
        return optional.orElseGet(USER_DETAILS::new);
    }
    //--------------affiche tout les users------
    @GetMapping("/users/list")
    public Page<USER_DETAILS> pageQuery(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum - 1, pageSize));
    }


    //---------Ajouter une role--------------

    @PostMapping("/addRole")
    public USER_ROLES saveRole(@RequestBody USER_ROLES name){
        return userService.saveRole(name);
    }



    //--------------supprimir user---------------


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }


    //--------------------------------Update-------------------------------------------//



    //------ Probleme update user whitout  role
    @PutMapping("/{id}")
    public USER_DETAILS updateUsertw(@PathVariable("id") Long id, @RequestBody USER_DETAILS user) {
        user.setId(id);
        return userRepository.saveAndFlush(user);

    }




    //------- work- without Roles change---------//

    @PutMapping("/updatenew/{id}")
    public ResponseEntity<USER_DETAILS> updateUser(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody USER_DETAILS userDetails ) throws ResourceNotFoundException {
        USER_DETAILS user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

        log.info("role ; {}",user.getRoles());
        user.setId(userDetails.getId());
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(encoder.encode(userDetails.getPassword()));

        log.info("role ; {}",userDetails.getRoles());
        user.setRoles(userDetails.getRoles());
        final USER_DETAILS updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }






}


