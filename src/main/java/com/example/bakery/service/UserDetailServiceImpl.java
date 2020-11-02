package com.example.bakery.service;

import com.example.bakery.domain.User;
import com.example.bakery.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User currentUser = userRepository.findByUsername(username);
            UserDetails user =new org.springframework.security.core.userdetails.User(username, currentUser.getPassword()
                    ,true, true, true, true,
            AuthorityUtils.createAuthorityList(currentUser.getRole()));
            return user;
    }
}
