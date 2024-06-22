package com.example.practice.controller;

import com.example.practice.domain.dto.ProductDTO2;
import com.example.practice.domain.vo.ProductVO;
import com.example.practice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
//RequestMapping 은 FrontController 하는 역할을 수행한다.
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public String index() {
        return "product/index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", productService.findALl());
        return "product/productList";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/detail";
    }

    @GetMapping("/write")
    public String goWriteForm(Model model) {
        model.addAttribute("product", new ProductDTO2());
        return "product/writeForm";
    }

    @PostMapping("/write")
    public String writeOk(@ModelAttribute ProductDTO2 product){
        ProductVO vo = ProductVO.toEntity(product);
        productService.save(vo);
        return "redirect:/product/list";
    }




}
