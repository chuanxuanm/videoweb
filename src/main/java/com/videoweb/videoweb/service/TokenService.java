package com.videoweb.videoweb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class TokenService {
    @Autowired
    private HttpServletRequest request;
    private static final String SECRET = "2227309156xby";

    // 过期时间，单位为秒
    private static final long EXPIRATION_TIME = 3600;


    //生成token,
    public String generateToken(String username,int userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME * 1000);

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        //注意withSubject(username)可以往里面存其他，一般都表示主题，如果还需要存自定义
        //可以使用withClaim("userId", 123)来存jwt.getClaim("userId").asInt()来取，
        //这个asInt表示转化成int类型
        return JWT.create()
                .withSubject(username)
                .withClaim("userId",userId)
                .withExpiresAt(expiryDate)
                .sign(algorithm);
    }

    //解析token
    public TokenInfo parseToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            String subject = jwt.getSubject();
            Date expiresAt = jwt.getExpiresAt();
            int userId=jwt.getClaim("userId").asInt();
            return new TokenInfo(subject, expiresAt,userId);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    // 校验token是否过期
    public boolean isTokenExpired(TokenInfo tokenInfo) {
        Date expiresAt = tokenInfo.getExpiresAt();
        return expiresAt == null || expiresAt.before(new Date());
    }

    //封装了JWT的一些基本信息，包括subject和过期时间
    public static class TokenInfo {
        private int userId;
        private String subject;
        private Date expiresAt;

        public TokenInfo(String subject, Date expiresAt,int userId) {
            this.subject = subject;
            this.expiresAt = expiresAt;
            this.userId=userId;
        }
        public int getUserId(){
            return  userId;
        }

        public String getSubject() {
            return subject;
        }

        public Date getExpiresAt() {
            return expiresAt;
        }
    }
}
