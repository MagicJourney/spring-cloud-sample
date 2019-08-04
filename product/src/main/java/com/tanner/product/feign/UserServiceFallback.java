package com.tanner.product.feign;

import com.tanner.product.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-24
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public List<UserDTO> list(Pageable pageable) {
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO(1L, "zhangSan_static", "/users/avatar/zhangsan.png", 8080));
        list.add(new UserDTO(2L, "lisi_static", "/users/avatar/lisi.png", 8080));
        list.add(new UserDTO(3L, "wangwu_static", "/users/avatar/wangwu.png", 8080));
        list.add(new UserDTO(4L, "yanxiaoliu_static", "/users/avatar/yanxiaoliu.png", 8080));
        return list;
    }

    @Override
    public UserDTO detail(UserDTO userDTO) {
        return new UserDTO(userDTO.getId(), "Anonymous", "default.png", 8080);
    }
}
