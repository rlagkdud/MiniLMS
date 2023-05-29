package com.zerobase.fastlms.main.controller;


import com.zerobase.fastlms.components.MailComponents;
import com.zerobase.fastlms.member.entity.Member;
import com.zerobase.fastlms.member.entity.MemberCode;
import com.zerobase.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        
        /*
        String email = "mailp@naver.com";
        String subject = " 안녕하세요. 제로베이스 입니다. ";
        String text = "<p>안녕하세요.</p><p>반갑습니다.</p>";
        
        mailComponents.sendMail(email, subject, text);
        */
        // 로그인을 하면 에러페이지로 이동하는데 그게 왜그런지 모르겠음.
        try {
            // 로그인 되어있는 상태로 /으로 가면, 로그인아이디와 로그인날짜,접속IP, 접속 UserAgent를 가져와서 출력해줌
            RequestUtils requestUtils = new RequestUtils();
            System.out.println(requestUtils.getClientIP(request));
            System.out.println(requestUtils.getLoginId(request));
            System.out.println(requestUtils.getUserAgent(request));


        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }


        return "index";
    }


    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }


}
