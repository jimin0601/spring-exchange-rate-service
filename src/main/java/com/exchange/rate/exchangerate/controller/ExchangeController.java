package com.exchange.rate.exchangerate.controller;

import com.exchange.rate.exchangerate.dto.ExchangeDTO;
import com.exchange.rate.exchangerate.service.ExchangeService;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ExchangeController {

    private final ExchangeService exchangeService;


    @PostMapping("/exchange")
    public ResponseEntity<Object> exchange(@RequestBody ExchangeDTO exchangeDTO) throws IOException {

        ExchangeDTO response = exchangeService.testExchange(exchangeDTO.getBaseCode(), exchangeDTO.getAmount());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}