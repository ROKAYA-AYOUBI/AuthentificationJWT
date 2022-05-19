package com.example.dashboardbe.Repository;



import com.example.dashboardbe.Domaine.USER_ROLES;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<USER_ROLES, Long> {


    Optional<USER_ROLES> findByName(String name);
/*
   @Query("SELECT r FROM Role r WHERE r.name = ?1")
   public Role findByName(String name);

 */
}
