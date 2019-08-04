package com.tanner.product.dto;

import com.tanner.product.entity.ProductCommentDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "商品评论DTO")
public class ProductCommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "商品id")
    private Long productId;

    @ApiModelProperty(value = "作者id")
    private Long authorId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "创建日期")
    private Date created;

    private ProductDTO product;

    private UserDTO author;

    public ProductCommentDTO(ProductCommentDO productCommentDO) {
        this.id = productCommentDO.getId();
        this.productId = productCommentDO.getProductId();
        this.authorId = productCommentDO.getAuthorId();
        this.content = productCommentDO.getContent();
        this.created = productCommentDO.getCreated();
    }

}
