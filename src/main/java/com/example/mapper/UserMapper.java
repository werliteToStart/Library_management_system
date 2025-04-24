package com.example.mapper;

import com.example.bean.Role;
import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User queryUserByUsername(String username);

    public User queryUserById(int id);

    public List<User> queryAllUser();

    public Role queryRoleById(int id);

    public int updateUser(User user);

    public int updateUserById(User user);
}
