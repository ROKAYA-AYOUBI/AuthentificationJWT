package com.example.dashboardbe.Service;



import com.example.dashboardbe.Domaine.Role;
import com.example.dashboardbe.Domaine.User;
import com.example.dashboardbe.Exception.ResourceNotFoundException;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;


public interface UserService {

    //-------update un user-------
    public User updateUser(Long id, User user);

    //----add Role -----
    public Role saveRole(Role role);

    //----Rest password
    public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException;
    public User getByResetPasswordToken(String token);
    public void updatePassword(User user, String newPassword);





    //----------- methode
    //User save(User user);
    User addRoleToUser(String username, String roleName) throws RoleNotFoundException;
    Optional<User> findByUsername(String username);
    List<User> findAll();



}
