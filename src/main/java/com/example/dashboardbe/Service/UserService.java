package com.example.dashboardbe.Service;



import com.example.dashboardbe.Domaine.Role;
import com.example.dashboardbe.Domaine.User;
import com.example.dashboardbe.Exception.ResourceNotFoundException;


public interface UserService {

    //-------update un user-------
    public User updateUser(Long id, User user);

    //----add Role -----
    public Role saveRole(Role role);

    //----Rest password
    public void updateResetPasswordToken(String token, String email) throws ResourceNotFoundException;
    public User getByResetPasswordToken(String token);
    public void updatePassword(User user, String newPassword);





    //-----------update methode





}
