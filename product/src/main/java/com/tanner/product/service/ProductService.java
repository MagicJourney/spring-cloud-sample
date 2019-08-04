package com.tanner.product.service;

import com.tanner.product.dto.ProductCommentDTO;
import com.tanner.product.dto.ProductDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
public interface ProductService {

    List<ProductDTO> list(Pageable pageable);

    ProductDTO getById(long id);

    List<ProductCommentDTO> comments(long productId);

}
