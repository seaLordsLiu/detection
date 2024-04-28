package org.sealord.api.trouble;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sealord.api.HEADER;
import org.sealord.api.trouble.vo.TroubleApiRequest;
import org.sealord.api.trouble.vo.WebTroubleApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author liu xw
 * @date 2024 04-28
 */
@SpringBootTest
@AutoConfigureMockMvc
class TroubleCampApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void receive_success() throws Exception {
        RuntimeException exception = new RuntimeException("this is test exception");
        TroubleApiRequest request = new TroubleApiRequest();
        request.setTrouble(exception.getClass().getName());
        request.setMessage(exception.getMessage());
        request.setInformation(exception.getLocalizedMessage());
        request.setCustomData("{}");
        request.setReportTime(Instant.now().getEpochSecond());

        MockHttpServletRequestBuilder rb = MockMvcRequestBuilders.post("/trouble-camp-api/receive")
                .header(HEADER.X_CLIENT_NAME, "mock_test")
                .header(HEADER.X_ENV_LABEL, "prod")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                // 使用Spring的序列化工具进行辅助测试
                .content(JacksonTypeHandler.getObjectMapper().writeValueAsString(request));
        mockMvc.perform(rb).andDo(System.out::print).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void receiveOnWeb_success() throws Exception {
        RuntimeException exception = new RuntimeException("this is test exception");
        WebTroubleApiRequest request = new WebTroubleApiRequest();
        request.setTrouble(exception.getClass().getName());
        request.setMessage(exception.getMessage());
        request.setInformation(exception.getLocalizedMessage());
        request.setCustomData("{}");
        request.setReportTime(Instant.now().getEpochSecond());

        // 补充web参数信息
        request.setUrl("http://localhost:8080/test");
        request.setUrlParam("qts=2&asd=3");
        request.setParam("GET");

        MockHttpServletRequestBuilder rb = MockMvcRequestBuilders.post("/trouble-camp-api/receive")
                .header(HEADER.X_CLIENT_NAME, "mock_test")
                .header(HEADER.X_ENV_LABEL, "prod")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                // 使用Spring的序列化工具进行辅助测试
                .content(JacksonTypeHandler.getObjectMapper().writeValueAsString(request));
        mockMvc.perform(rb).andDo(System.out::print).andExpect(MockMvcResultMatchers.status().isOk());
    }
}