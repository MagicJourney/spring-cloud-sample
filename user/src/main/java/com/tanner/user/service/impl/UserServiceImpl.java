package com.tanner.user.service.impl;

import com.tanner.user.dto.UserDTO;
import com.tanner.user.entity.UserDO;
import com.tanner.user.repository.UserRepository;
import com.tanner.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-15
 */
@Service
public class UserServiceImpl implements UserService {
    @Value("${server.port}")
    private int serverPort;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> list(Pageable pageable) {
        if (pageable == null) {
            pageable = new PageRequest(0,10);
        }
        Page<UserDO> page = userRepository.findAll(pageable);
        if (null != page) {
            return page.getContent().stream().map((user) -> {
                return new UserDTO(user, serverPort);
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public UserDTO getById(long id) {
        UserDO userDO = userRepository.findById(id).get();
        return new UserDTO(userDO, serverPort);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDTO save(UserDTO userDTO) {
        Long id = userDTO.getId();
        UserDO userDO = new UserDO();
        if (id != null) {
            userDO = userRepository.findById(id).get();
        } else {
            userDO = new UserDO();
        }
        userDO.setNickname(userDTO.getNickname());
        userDO.setAvatar(userDTO.getAvatar());
        UserDO userDORes = userRepository.save(userDO);
        UserDTO userDTORes = new UserDTO(userDORes,serverPort);
        return userDTORes;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean del(long id) {
        userRepository.deleteById(id);
        return true;
    }
}
