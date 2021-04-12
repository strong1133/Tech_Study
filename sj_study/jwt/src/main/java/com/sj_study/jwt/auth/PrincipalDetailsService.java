package com.sj_study.jwt.auth;

import com.sj_study.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.sj_study.jwt.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        System.out.println("PrincipalDetailsService");
        User userEntity = userRepository.findByUsername(username);
        return new PrincipalDetails(userEntity);
    }


}
