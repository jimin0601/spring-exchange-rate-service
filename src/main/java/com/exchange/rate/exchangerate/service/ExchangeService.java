package com.exchange.rate.exchangerate.service;

import com.exchange.rate.exchangerate.dto.ExchangeDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ExchangeService {
    // 요청 URL
    private final String URL = "https://api.exchangerate.host/latest";
    // 파라미터로 통화 단위와, 금액을 받음
    public ExchangeDTO exchangeCurrency(String baseCode, double amount) throws IOException {
        // API 요청
        URL url = new URL(URL + "?base="+ baseCode + "&amount=" + amount);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // JSON -> String 데이터 파싱
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        String req_result = jsonobj.get("success").getAsString();
        String base = jsonobj.get("base").getAsString();
        String rates = jsonobj.get("rates").toString();

        ExchangeDTO exchangeDTO = new ExchangeDTO().toDTO(req_result, base, rates);

        return exchangeDTO;
    }
}
