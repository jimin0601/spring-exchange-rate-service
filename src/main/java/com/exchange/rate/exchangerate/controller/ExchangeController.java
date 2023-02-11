package com.exchange.rate.exchangerate.controller;

import com.exchange.rate.exchangerate.dto.ExchangeDTO;
import com.exchange.rate.exchangerate.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
// CORS 에러 방지
@CrossOrigin(origins = "http://localhost:3000")
public class ExchangeController {

    private final ExchangeService exchangeService;


    // 요청받는 컨트롤러
    @PostMapping("/exchange")
    public ResponseEntity<Object> exchange(@RequestBody ExchangeDTO exchangeDTO) throws IOException {

        ExchangeDTO response = exchangeService.exchangeCurrency(exchangeDTO.getBaseCode(), exchangeDTO.getAmount());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}