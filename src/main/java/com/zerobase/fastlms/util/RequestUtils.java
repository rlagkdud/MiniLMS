package com.zerobase.fastlms.util;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
    public String getClientIP(HttpServletRequest request){
        String ip = request.getHeader("X-FORWARDED-FOR");

        //proxy 환경일 경우
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        //웹로직 서버일 경우
        if (ip == null || ip.length() == 0) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0) {
            ip = request.getRemoteAddr() ;
        }
       return ip;
    }

    public String getUserAgent(HttpServletRequest request){
        String userAgent = request.getHeader("user-agent");
        return userAgent;
    }

    public String getLoginId(HttpServletRequest request){
        String loginId = request.getUserPrincipal().getName();
        return loginId;
    }
}
