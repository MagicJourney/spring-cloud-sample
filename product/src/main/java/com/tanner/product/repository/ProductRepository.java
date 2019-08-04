package com.tanner.product.repository;

import com.tanner.product.entity.ProductDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
public interface ProductRepository extends JpaRepository<ProductDO, Long> {
}
