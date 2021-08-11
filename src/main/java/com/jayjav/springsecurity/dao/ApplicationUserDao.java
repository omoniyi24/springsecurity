package com.jayjav.springsecurity.dao;

import com.jayjav.springsecurity.auth.ApplicationUser;

import java.util.Optional;

/**
 * @author OMONIYI ILESANMI
 */

public interface ApplicationUserDao {

    public Optional<ApplicationUser> selectApplicationByUsername(String username);
}
