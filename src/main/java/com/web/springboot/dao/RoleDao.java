package com.web.springboot.dao;

import com.web.springboot.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoles();

    Role getRoleById(Long id);

}
