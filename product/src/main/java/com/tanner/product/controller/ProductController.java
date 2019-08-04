package com.tanner.product.controller;

import com.tanner.product.dto.ProductCommentDTO;
import com.tanner.product.dto.ProductDTO;
import com.tanner.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
@RestController
@RefreshScope
@RequestMapping("/product")
@Api(tags = "商品")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Value("${info}")
    private String info;

    @PostMapping("/list")
    @ApiOperation(value = "查询商品列表")
    public List<ProductDTO> list(@RequestBody(required = false) Pageable pageable) {
        return productService.list(pageable);
    }

    @PostMapping("/detail")
    @ApiOperation(value = "查询商品详情")
    public ProductDTO detail(@RequestBody ProductDTO productDTO) {
        return productService.getById(productDTO.getId());
    }

    @PostMapping("/comments")
    @ApiOperation(value = "查询商品评论列表")
    public List<ProductCommentDTO> comments(@RequestBody ProductDTO productDTO) {
        return productService.comments(productDTO.getId());
    }

    @GetMapping("/test-config")
    public String testConfig() {
        return info;
    }

}
