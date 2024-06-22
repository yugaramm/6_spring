package com.example.practice.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDTO2 {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private String description;

}
