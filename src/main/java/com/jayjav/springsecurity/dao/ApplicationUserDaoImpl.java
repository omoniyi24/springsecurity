package com.jayjav.springsecurity.dao;

import com.google.common.collect.Lists;
import com.jayjav.springsecurity.auth.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.jayjav.springsecurity.enums.ApplicationUserRole.*;

/**
 * @author OMONIYI ILESANMI
 */

@Repository("fake")
public class ApplicationUserDaoImpl implements ApplicationUserDao{

    private final static String PASSWORD = "password";


    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationByUsername(String username) {
        return getApplicationUsers()
            .stream()
            .filter(applicationUser -> username.equals(applicationUser.getUsername()))
            .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        return Lists.newArrayList(
            new ApplicationUser(
                "omoniyi",
                passwordEncoder.encode(PASSWORD),
                STUDENT. getGrantedAuthorities(),
                true,
                true,
                true,
                true
            ),
            new ApplicationUser(
                "sunkanmi",
                passwordEncoder.encode(PASSWORD),
                ADMIN. getGrantedAuthorities(),
                true,
                true,
                true,
                true
            ),
            new ApplicationUser(
                "tom",
                passwordEncoder.encode(PASSWORD),
                ADMINTRAINEE. getGrantedAuthorities(),
                true,
                true,
                true,
                true
            )
        );
    }
}
