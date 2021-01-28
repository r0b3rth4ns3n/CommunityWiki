package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import com.r0b3rth4ns3n.CommunityWiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("my-user-service")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findById(username).orElseThrow( () -> { throw new UsernameNotFoundException(username); } );
    }

    public String register(String username, String password) {
        if (userRepo.findById(username).isPresent()) return "username already in use";
        userRepo.save(new User(username,passwordEncoder.encode(password)));
        return "successfully registered";
    }

    public User saveUser(User u) {
        return userRepo.save(u);
    }

    public User findUser(String username) {
        return userRepo.findById(username).orElse(null);
    }

}
