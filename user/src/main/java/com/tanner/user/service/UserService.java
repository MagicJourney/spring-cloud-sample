package com.tanner.user.service;

import com.tanner.user.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-15
 */
public interface UserService {

    List<UserDTO> list(Pageable pageable);

    UserDTO getById(long id);

    UserDTO save(UserDTO userDTO);

    boolean del(long id);




}
