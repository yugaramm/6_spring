package com.example.product_final.service;

import com.example.product_final.domain.vo.ProductVO;
import com.example.product_final.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 특정 변수의 생성자를 만들어주는 어노테이션.
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // 생성자 주입
    // @Autowired 생략 가능.
    private final ProductMapper productMapper;

    // 전체 물품 리스트를 반환하는 select
    @Override
    public List<com.example.product_final.domain.dto.ProductDTO> findAll() {
        return productMapper.selectList();
    }

    // 상세보기 페이지로 보낼 데이터 select
    @Override
    public com.example.product_final.domain.dto.ProductDetailDTO findById(long id) {
        return productMapper.selectOne(id);
    }

    // 새 물품 등록 insert
    @Override
    public int save(ProductVO vo) {
        return productMapper.insert(vo);
    }

    // 물품 정보 수정 update
    @Override
    public void edit(ProductVO vo) {
        productMapper.update(vo);
    }

    @Override
    public int delete(long id) {
        return productMapper.delete(id);
    }
}