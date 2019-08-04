package com.tanner.product.feign;

import com.tanner.product.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-23
 */
@FeignClient(name = "USER", fallback = UserServiceFallback.class)
@Component
public interface UserService {

    @PostMapping(value = "/user/list")
    List<UserDTO> list(@RequestBody Pageable pageable);

    @PostMapping(value = "/user/detail")
    UserDTO detail(@RequestBody UserDTO userDTO);


}
