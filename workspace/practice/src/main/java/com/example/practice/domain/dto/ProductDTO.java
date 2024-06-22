package com.example.practice.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductDTO {

    private Long id;
    private String name;

}