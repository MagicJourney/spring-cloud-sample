package com.tanner.product.dto;

import com.tanner.product.entity.ProductDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description
 * @Author: zhangtiancheng
 * @Date: 2019-07-16
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "商品DTO")
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "商品图片")
    private String coverImage;

    @ApiModelProperty(value = "价格")
    private int price;

    public ProductDTO(ProductDO productDO) {
        this.id = productDO.getId();
        this.name = productDO.getName();
        this.coverImage = productDO.getCoverImage();
        this.price = productDO.getPrice();
    }
}
