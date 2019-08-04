package com.tanner.product.service.impl;

import com.tanner.product.dto.ProductCommentDTO;
import com.tanner.product.dto.ProductDTO;
import com.tanner.product.dto.UserDTO;
import com.tanner.product.entity.ProductCommentDO;
import com.tanner.product.entity.ProductDO;
import com.tanner.product.repository.ProductCommentRepository;
import com.tanner.product.repository.ProductRepository;
import com.tanner.product.service.ProductService;
import com.tanner.product.feign.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCommentRepository productCommentRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    UserService userService;

    @Override
    public List<ProductDTO> list(Pageable pageable) {
        if (pageable == null) {
            pageable = new PageRequest(0,10);
        }
        Page<ProductDO> page = productRepository.findAll(pageable);
        if (null != page) {
            return page.getContent().stream().map((product) -> {
                return new ProductDTO(product);
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public ProductDTO getById(long id) {
        ProductDO productDO = productRepository.findById(id).get();
        ProductDTO productDTO = new ProductDTO(productDO);
        return productDTO;
    }

    @Override
    public List<ProductCommentDTO> comments(long productId) {
        List<ProductCommentDO> list = productCommentRepository.findByProductIdOrderByCreated(productId);
        if (null != list) {
            return list.stream().map((comment) -> {
                ProductCommentDTO dto =  new ProductCommentDTO(comment);
                dto.setProduct(new ProductDTO(productRepository.findById(productId).get()));
                UserDTO params = new UserDTO();
                params.setId(comment.getAuthorId());
                // UserDTO user = restTemplate.postForEntity("http://USER/user/detail", params, UserDTO.class).getBody();
                UserDTO user = userService.detail(params);
                if (user != null) {
                    log.info("i came from server: {}", user.getUserServicePort());
                }
                dto.setAuthor(user);
                return dto;
            }).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }


}
