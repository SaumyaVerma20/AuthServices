package com.AuthService.AuthService.repository;


import com.AuthService.AuthService.entities.Userinfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Userinfo, Long> {

    public Userinfo findByUserName(String userName);
}
