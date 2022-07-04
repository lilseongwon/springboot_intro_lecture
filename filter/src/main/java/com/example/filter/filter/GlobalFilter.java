package com.example.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*") //특정 컨트롤러에만 실행
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //전처리
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest)request); //내용을 담아서 계속 읽을 수 있다.
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);

        String url = httpServletRequest.getRequestURI(); //요청 주소값

        chain.doFilter(httpServletRequest, httpServletResponse);

        //후처리
        //req
        String reqContent = new String(httpServletRequest.getContentAsByteArray()); //???? 알아보기

        log.info("request url : {}, requestBody : {}", url, reqContent); //로그(url, content)

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus(); //status는 숫자니까 int

        httpServletResponse.copyBodyToResponse(); //커서가 내려갈 때 복사(copy)해서 클라이언트가 응답받음

        log.info("response status : {}, responseBody : {}", httpStatus, resContent);
    }
}
