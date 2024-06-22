package com.example.practice.service;

import com.example.practice.domain.dto.ProductDTO;
import com.example.practice.domain.dto.ProductDetailDTO;
import com.example.practice.domain.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductDTO> findALl();

    ProductDetailDTO findById(Long id);

    ProductVO save(ProductVO vo);

}
