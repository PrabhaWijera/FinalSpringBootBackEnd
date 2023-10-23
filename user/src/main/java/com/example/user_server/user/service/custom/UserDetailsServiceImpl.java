package com.example.user_server.user.service.custom;


import com.example.user_server.user.dto.User_dto;
import com.example.user_server.user.entity.UserEntity;
import com.example.user_server.user.repo.User_repo;
import com.example.user_server.user.res.ResponseController;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private User_repo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepo.findByUserName(userName);
        System.out.println(userName);
        return user.isPresent() ? user.get() : user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));



    }

}
