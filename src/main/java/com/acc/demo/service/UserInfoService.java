package com.acc.demo.service;

import com.acc.demo.dao.UserInfoDAO;
import com.acc.demo.entity.UserInfo;
import com.acc.demo.entity.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserInfoDAO dao;

        @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserInfo user =dao.findUserByUsername(username);
         if(user==null){
             throw new UsernameNotFoundException("This user is not Found!");
         }
        return new UserInfoDetails(user);
    }



}
