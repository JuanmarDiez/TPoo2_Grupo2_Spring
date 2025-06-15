package com.example.TP_OO2_Turnos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TP_OO2_Turnos.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable>{
	
	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.email = (:email)")
	public abstract User findByEmailAndFetchUserRolesEagerly(@Param("email") String email);
	
}
