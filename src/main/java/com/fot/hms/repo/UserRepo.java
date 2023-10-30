package com.fot.hms.repo;

import com.fot.hms.model.UsersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserRepo extends JpaRepository<UsersEntity, Integer> {

    @Query(value = "CALL InsertUserWithEncryptedPassword(:indexNo, :name, :email, :mobileNo, :password, :role)", nativeQuery = true)
    String createUserWithEncryptedPassword(
            @Param("indexNo") String indexNo,
            @Param("name") String name,
            @Param("email") String email,
            @Param("mobileNo") String mobileNo,
            @Param("password") String password,
            @Param("role") int role
    );

    @Query(value = "CALL AuthenticateUser(:identifier, :password)", nativeQuery = true)
    List<Map<String, Object>> authenticateUser(
            @Param("identifier") String identifier,
            @Param("password") String password
    );

    @Query(value = "CALL UpdateUser(:id, :indexNo, :name, :email, :mobileNo, :password, :role)", nativeQuery = true)
    List<Map<String, Object>> updateUser(
            @Param("id") int id,
            @Param("indexNo") String indexNo,
            @Param("name") String name,
            @Param("email") String email,
            @Param("mobileNo") String mobileNo,
            @Param("password") String password,
            @Param("role") int role
    );



}
