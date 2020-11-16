package com.web.springboot.secutity;

import com.web.springboot.dao.UserDao;
import com.web.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        User user = userDao.getUserByFirstName(firstName);

        if (user == null) {
            throw new UsernameNotFoundException("пользователь не найден");
        }
        return user;
    }
}
