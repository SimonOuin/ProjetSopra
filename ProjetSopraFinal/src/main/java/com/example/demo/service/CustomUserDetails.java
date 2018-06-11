package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.example.demo.model.RessourceHumaine;

public class CustomUserDetails extends RessourceHumaine implements UserDetails {

	List<String> roles;

	public CustomUserDetails(RessourceHumaine rh, List<String> roles) {
		super(rh);
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roles));

	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		//return super.isEnable();
		return true;
	}

	@Override
	public String getPassword() {
		return super.getMdp();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}

}
