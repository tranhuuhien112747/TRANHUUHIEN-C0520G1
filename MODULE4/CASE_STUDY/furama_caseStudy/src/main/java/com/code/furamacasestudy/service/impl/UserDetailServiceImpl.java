//package com.code.furamacasestudy.service.impl;
//
//import com.code.furamacasestudy.model.login.Role;
//import com.code.furamacasestudy.model.login.User;
//import com.code.furamacasestudy.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Can not found!");
//        }
//        Set<Role> roleSetList = user.getRoles();
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//        for (Role role : roleSetList) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
//            grantedAuthorityList.add(grantedAuthority);
//        }
//        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), grantedAuthorityList);
//        return userDetails;
//    }
//
//}
