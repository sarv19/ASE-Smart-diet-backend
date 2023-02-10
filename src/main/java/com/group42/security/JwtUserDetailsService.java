//package com.group42.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//public class JwtUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String user){
//    	log.info("JwtUserDetailsService:{}" ,user);
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
//       return new SecurityUserDetails(user,authorityList);
//
//   }
//
//}