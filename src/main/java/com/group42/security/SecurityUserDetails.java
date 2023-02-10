//package com.group42.security;
//
//import com.mtrsz.common.data.SessionUser;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.experimental.Accessors;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//@Data
//@EqualsAndHashCode(callSuper = true)
//@Accessors(chain = true)
//public class SecurityUserDetails extends SessionUser implements UserDetails {
//
//	private static final long serialVersionUID = -1617490015179895028L;
//
//	private Collection<? extends GrantedAuthority> authorities;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public SecurityUserDetails(String username, Collection<? extends GrantedAuthority> authorities){
//        this.authorities = authorities;
//        this.setUserName(username);
//
//        this.setAuthorities(authorities);
//    }
//
//	@Override
//	public String getPassword() {
//		return this.getPassword();
//	}
//	@Override
//	public boolean isAccountNonExpired() {
//		return false;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return false;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return false;
//	}
//
//	@Override
//	public String getUsername() {
//		return this.getUserName();
//	}
//}
