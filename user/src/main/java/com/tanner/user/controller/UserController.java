package com.tanner.user.controller;

import com.tanner.user.dto.UserDTO;
import com.tanner.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-15
 */
@RequestMapping("/user")
@RestController
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation(value = "查询用户列表")
    public List<UserDTO> list(@ApiParam(value = "分页对象") @RequestBody(required = false) Pageable pageable) {
        return userService.list(pageable);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "查询用户详情")
    public UserDTO detail(@ApiParam(value = "用户DTO") @RequestBody UserDTO userDTO) {
        return userService.getById(userDTO.getId());
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增/修改用户")
    public UserDTO save(@ApiParam(value = "用户DTO") @RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除用户")
    public boolean del(@ApiParam(value = "用户DTO") @RequestBody UserDTO userDTO) {
        return userService.del(userDTO.getId());
    }


}
