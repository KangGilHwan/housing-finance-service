package com.riverway.housingfinance.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import support.test.AcceptanceTest;
import support.test.HtmlFormDataBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class HousingFinanceAcceptanceTest extends AcceptanceTest {

    @Test
    public void analyzeCsvFile_test() {
        ClassPathResource csvFile = new ClassPathResource("주택금융신용보증_금융기관별_공급현황.csv");
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder
                .multipartFormData()
                .addParameter("csvFile", csvFile)
                .build();

        ResponseEntity<String> response = template().postForEntity("/api/housing/finance", request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertTrue(response.getHeaders().getLocation().getPath().startsWith("/api/housing/finance"));
    }
}
