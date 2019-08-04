package com.tanner.product.repository;

import com.tanner.product.entity.ProductCommentDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
public interface ProductCommentRepository extends JpaRepository<ProductCommentDO, Long> {
    List<ProductCommentDO> findByProductIdOrderByCreated(Long productId);
}
