package com.shaon.spring.webmvc.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;

public class SamlUserDetailsService implements SAMLUserDetailsService {
    public String DUMMY_PASSWORD = "DUMMY_PASSWORD";
    @Override
    public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
        try {
            String username = credential.getAttributeAsString("UserID");
            if (username.equals("shaon.sso")) {
                username = "shaon";
                DUMMY_PASSWORD = "123";
            }

            return username;
        } catch (Exception e) {

        }
        throw new UsernameNotFoundException("invalid username/password");
    }
}
