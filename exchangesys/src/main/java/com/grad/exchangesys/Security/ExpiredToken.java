package com.grad.exchangesys.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


import static java.util.Arrays.stream;

public class ExpiredToken {
    public int checkExpire(HttpServletRequest request) throws IOException, InterruptedException {
        Cookie[] authCookie = request.getCookies();
        final String[] token_cookie=new String[2];

        stream(authCookie).forEach(cookie -> {
            if (cookie.getName().equals("access_token")){
                token_cookie[0] = cookie.getValue();
            }
            if (cookie.getName().equals("refresh_token")){
                token_cookie[1] = cookie.getValue();
            }
        });
        String token = token_cookie[0];
        String refreshtoken = token_cookie[1];
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
       return 0;
        }
        catch (Exception e){

            try {
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWTR = verifier.verify(refreshtoken);
                return 1;
            }
            catch (Exception e1){
                return 2;
            }
        }

    }

}
