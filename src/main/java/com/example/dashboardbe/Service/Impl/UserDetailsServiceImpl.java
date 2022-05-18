package com.example.dashboardbe.Service.Impl;



import com.example.dashboardbe.Domaine.Role;
import com.example.dashboardbe.Domaine.User;
import com.example.dashboardbe.Exception.ResourceNotFoundException;
import com.example.dashboardbe.Repository.RoleRepository;
import com.example.dashboardbe.Repository.UserRepository;
import com.example.dashboardbe.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;



@Service
@Transactional
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService , UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;

    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }



    //------------les methode  de interface UserService ------



    //----------------  update  ----------------
    @Override
    public User updateUser(Long id, User user) {

        Optional<User> retrievedUser=userRepository.findById(id);
        if(retrievedUser==null)
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        userRepository.save(user);
        return userRepository.findById(id).get();

    }




    //-----------------Rest Password-----------------
    public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(token);
            userRepository.save(user);
        } else {
            throw new ResourceNotFoundException("Could not find any customer with the email " + email);
        }
    }

    public User getByResetPasswordToken(String token) {
        return userRepository.findByPassword(token);
    }

    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setPassword(null);
        userRepository.save(user);
    }
//-------------------------





 //----------------  add roles  ----------------
    @Override
    public Role saveRole(Role role) {
        log.info("Saving role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    //----------------  add roles  TO USER ----------------
    @Override
    public User addRoleToUser(String username, String roleName) throws RoleNotFoundException {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RoleNotFoundException("User Not Found with role: " + roleName));

       user.getRoles().add(role);
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        log.info("Retrieving all users");
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findByUsername(String username) {
        log.info("Retrieving user {}", username);
        return userRepository.findByUsername(username);
    }


}

