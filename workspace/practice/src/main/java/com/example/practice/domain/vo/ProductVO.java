package com.example.practice.domain.vo;

import com.example.practice.domain.dto.ProductDTO2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@ToString
public class ProductVO {
    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;

    @Builder
    public ProductVO(Long id, String name, Double price, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public static ProductVO toEntity(ProductDTO2 productDTO2) {
        return ProductVO.builder().id(productDTO2.getId())
                .name(productDTO2.getName())
                .price(productDTO2.getPrice())
                .category(productDTO2.getCategory())
                .description(productDTO2.getDescription()).build();
    }
}