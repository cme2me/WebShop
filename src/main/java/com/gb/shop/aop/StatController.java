package com.gb.shop.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {
    @GetMapping("/stat")
    public ResponseEntity<StatDTO> getStatistic() {
        return new ResponseEntity<>(Stats.getStatistic(), HttpStatus.OK);
    }
}
