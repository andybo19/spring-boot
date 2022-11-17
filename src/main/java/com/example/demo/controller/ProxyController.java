package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;

/**
 * @author wan yu
 * @date 2022/6/24 下午5:51
 */
@Controller
public class ProxyController {


    private final String TARGET_ADDRESS = "https://pre-dengta.taopiaopiao.com/login";

    @RequestMapping(value = "/proxy/login", produces = MediaType.TEXT_HTML_VALUE)
    public void proxy(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException {
        String target = TARGET_ADDRESS;
        URI newUri = new URI(target);
        // 执行代理查询
        String methodName = request.getMethod();
        HttpMethod httpMethod = HttpMethod.resolve(methodName);
        if (httpMethod == null) {
            return;
        }
        ClientHttpRequest delegate = new SimpleClientHttpRequestFactory().createRequest(newUri, httpMethod);
        Enumeration<String> headerNames = request.getHeaderNames();
        // 设置请求头
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> v = request.getHeaders(headerName);
            HttpHeaders headers = delegate.getHeaders();
            while (v.hasMoreElements()) {
                headers.add(headerName, v.nextElement());
            }
        }
        StreamUtils.copy(request.getInputStream(), delegate.getBody());
        // 执行远程调用
        ClientHttpResponse clientHttpResponse = delegate.execute();
        response.setStatus(clientHttpResponse.getStatusCode().value());
        // 设置响应头
        clientHttpResponse.getHeaders().forEach((key, value) -> value.forEach(it -> {
            response.setHeader(key, it);
        }));
        StreamUtils.copy(clientHttpResponse.getBody(), response.getOutputStream());


    }


    @GetMapping("/fbi.html")
    public String login(){
        return "/index.html";
    }

    @GetMapping("/login")
    public String loginTest(){
        return "/login.html";
    }

    @GetMapping("/fbi/test.html")
    public String baidu(){
        return "/baidu.html";
    }


}
