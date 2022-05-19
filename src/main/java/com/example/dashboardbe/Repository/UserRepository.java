package com.example.dashboardbe.Repository;


import com.example.dashboardbe.Domaine.USER_DETAILS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<USER_DETAILS,Long> {

    Optional<USER_DETAILS> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);



    //------------forget pwd
    @Query("SELECT u FROM USER_DETAILS u WHERE u.email = ?1")
    public USER_DETAILS findByEmail(String email);
    public USER_DETAILS findByPassword(String token);





}

