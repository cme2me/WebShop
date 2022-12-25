package com.example.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RequestParamsForFilterByNameAndPrice {
    private String name;
    private Double fromPrice;
    private Double toPrice;
}
