package com.lucent.demo.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucent.demo.model.Customer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

@Service
public class HttpServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${shopify.access_token}")
    private String shopifyAccessToken;

    public List<Customer> fetchCustomerFromShopify() throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Shopify-Access-Token", shopifyAccessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ResponseEntity<List<Customer>>> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange("https://securecod4.myshopify.com/admin/api/2020-01/customers.json", HttpMethod.GET, entity, String.class);
        JSONObject json = new JSONObject(response.getBody());
        List<Customer> customerList = new ObjectMapper().readValue(json.getJSONArray("customers").toString(), new TypeReference<List<Customer>>() {});
        return customerList;
    }
}
