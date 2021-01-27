package com.r0b3rth4ns3n.CommunityWiki.service;

import com.r0b3rth4ns3n.CommunityWiki.entity.User;
import com.r0b3rth4ns3n.CommunityWiki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username)
                .orElseThrow( () -> {
                    throw new UsernameNotFoundException(username);
                });
        return user;
    }

    public String register(String username, String password) {
        if(userRepo.findById(username).isPresent()) return "username already in use";
        User user = new User(username,passwordEncoder.encode(password));
        userRepo.save(user);
        return "successfully registered";
    }

    public void save(User u) {
        userRepo.save(u);
    }

    // find
    public User find_user(String username) {
        return userRepo.findById(username).orElse(null);
    }

}
