package com.gb.shop.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatDTO {
    private Long basketService;
    private Long productService;
    private Long userService;
}
