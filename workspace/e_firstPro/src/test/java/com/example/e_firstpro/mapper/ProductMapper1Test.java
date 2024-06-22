package com.example.e_firstpro.mapper;

import com.example.e_firstpro.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ProductMapper1Test {

    @Autowired
    private ProductMapper1 productMapper1;

    @Test
    void insertTest(){
        ProductVO vo =
                ProductVO.builder()
                        .name("laptop")
                        .price(999.4)
                        .category("electonic")
                        .description("good")
                        .build();

        productMapper1.insert(vo);
    }

    @Test
    void findByNameTest(){
//        String search = "ea";
        String search = null;

        List<ProductVO> productVOS = productMapper1.findByName(search);
        log.info("검색 결과 갯수 : " + productVOS.size());
        productVOS.stream().map(ProductVO::toString).forEach(log::info);
    }

    @Test
    void findByConditionsTest(){
//        String name = null;
//        String category = "Electronics";
//        int price = 300;
        String name = null;
        String category = null;
        int price = 0;

        List<ProductVO> productVOS = productMapper1.findByConditions(name, category, price);
        log.info("검색 결과 갯수 : " + productVOS.size());
        productVOS.stream().map(ProductVO::toString).forEach(log::info);
    }

    @Test
    void findByChooseTest(){
        String name = "Apple iPhone";
        String category = "Electronics";
        int price = 1000;

        List<ProductVO> productVOS = productMapper1.findByChoose(name, category, price);
        log.info("검색 결과 갯수 : " + productVOS.size());
        productVOS.stream().map(ProductVO::toString).forEach(log::info);
    }


    @Test
    void updateTest(){
        ProductVO vo =
                ProductVO.builder()
                        .id(16L)
                        .name("류호근")
//                        .price(999999.99)
//                        .category("human")
                        .description("awesome")
                        .build();
        log.info(vo.toString());

        productMapper1.update(vo);
    }


















}