package com.example.practice.service;

import com.example.practice.domain.dto.ProductDTO;
import com.example.practice.domain.dto.ProductDetailDTO;
import com.example.practice.domain.vo.ProductVO;
import com.example.practice.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> findALl() {
        return productMapper.selectList();
    }

    @Override
    public ProductDetailDTO findById(Long id) {
        return productMapper.selectOne(id);
    }

    @Override
    public ProductVO save(ProductVO vo) {
        return productMapper.insert(vo);
    }
}
