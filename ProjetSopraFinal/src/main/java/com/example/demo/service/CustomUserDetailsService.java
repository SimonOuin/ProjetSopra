package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.RessourceHumaineRepository;
import com.example.demo.repository.RessourceHumaineRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	RessourceHumaineRepository RHRepository;
	@Autowired
	RessourceHumaineRoleRepository RHRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		RessourceHumaine rh= RHRepository.findByLogin(arg0);
		if (rh == null) {
			throw new UsernameNotFoundException("utilisateur inconnu");
		}
		return new CustomUserDetails(rh, RHRoleRepository.findCustomRoleByLogin(arg0));

	}

}
