package com.schedule.demo.Services;

import com.schedule.demo.Entities.Role;
import com.schedule.demo.Entities.Usser;
import com.schedule.demo.Repository.RoleRepository;
import com.schedule.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceUtil implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public String regAcc(String login, String password){

        Usser user = userRepository.findByLogin(login);
        if (user == null) {

            Usser newUser = new Usser();
            newUser.setLogin(login);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
            newUser.setPassword(encoder.encode(password));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findOne((int) 2));
            newUser.setRoles(roles);

            userRepository.save(newUser);

            return "succreg";
        }
        return "failreg";

    }
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            Usser client = userRepository.findByLogin(login);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getLogin(),
                    client.getPassword(),
                    client.getRoles());
        } catch (Exception repositoryProblem){
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return  loadedUser;
    }
}
