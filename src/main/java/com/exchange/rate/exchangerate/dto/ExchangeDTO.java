package com.exchange.rate.exchangerate.dto;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDTO {

    private String result;
    private String baseCode;
    private String obj;
    private double amount;

    public ExchangeDTO toDTO(String result, String baseCode, String obj) {
        this.result = result;
        this.baseCode = baseCode;
        this.obj = obj;

        return this;
    }
}
