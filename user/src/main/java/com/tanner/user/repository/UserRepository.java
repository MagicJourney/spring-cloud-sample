package com.tanner.user.repository;

import com.tanner.user.entity.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-15
 */
public interface UserRepository extends JpaRepository<UserDO, Long> {
}
