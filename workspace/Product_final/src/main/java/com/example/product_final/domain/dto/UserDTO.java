package com.example.product_final.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDTO {

    private String userId;
    private String email;
    private String password;

}
