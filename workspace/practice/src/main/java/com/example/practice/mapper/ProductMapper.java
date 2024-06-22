package com.example.practice.mapper;

import com.example.practice.domain.dto.ProductDTO;
import com.example.practice.domain.dto.ProductDetailDTO;
import com.example.practice.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductVO> selectTest();

    //리스트 화면에 뿌려줄 SQL
    List<ProductDTO> selectList();

    ProductDetailDTO selectOne(Long id);

    ProductVO insert(ProductVO vo);
}
