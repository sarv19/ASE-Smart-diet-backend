package com.group42.model.bean;

import com.group42.model.entity.User;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;

@ToString
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SecurityUserDetails extends User implements UserDetails {

	@Serial
	private static final long serialVersionUID = -1617490015179895028L;

	private final Collection<? extends GrantedAuthority> authorities;

    public SecurityUserDetails(String username, Collection<? extends GrantedAuthority> authorities){
		super();
		this.authorities = authorities;
        this.setUserName(username);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
