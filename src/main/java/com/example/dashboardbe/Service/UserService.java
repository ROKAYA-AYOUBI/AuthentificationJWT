package com.example.dashboardbe.Service;



import com.example.dashboardbe.Domaine.ROLES;
import com.example.dashboardbe.Domaine.USER_DETAILS;
import com.example.dashboardbe.Exception.ResourceNotFoundException;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;


public interface UserService {

    //-------update un user-------
    public USER_DETAILS updateUser(Long id, USER_DETAILS user);

    //----add Role -----
    public ROLES saveRole(ROLES role);

    //----Rest password
    public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException;
    public USER_DETAILS getByResetPasswordToken(String token);
    public void updatePassword(USER_DETAILS user, String newPassword);





    //----------- methode
    //User save(User user);
    USER_DETAILS addRoleToUser(String username, String roleName) throws RoleNotFoundException;
    Optional<USER_DETAILS> findByUsername(String username);
    List<USER_DETAILS> findAll();



}
