package com.grad.exchangesys.Filter;






import com.grad.exchangesys.Security.ExpiredToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;



@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {



    ExpiredToken expiredToken=new ExpiredToken();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {




        if (request.getServletPath().equals("/api/login") ||

                request.getServletPath().equals("/api/checkExpire") ||
                request.getServletPath().equals("/api/signup") ||
                request.getServletPath().equals("/") ||

                request.getServletPath().startsWith("/js") ||
                request.getServletPath().startsWith("/css") ||
                request.getServletPath().startsWith("/lib") ||
                request.getServletPath().startsWith("/plugins") ||
                request.getServletPath().startsWith("/styles") ||
                request.getServletPath().equals("/api/register")


        ){

        filterChain.doFilter(request,response);
        }else{

            try {
                int value= expiredToken.checkExpire(request);

                if(value == 0){
                    RequestDispatcher requestDispatcher = request
                            .getRequestDispatcher(request.getServletPath());
                    requestDispatcher.forward(request, response);

                   // filterChain.doFilter(request,response);
                }
                else if(value == 1){
                String url=request.getServletPath();
                request.setAttribute("url",url);
                    RequestDispatcher requestDispatcher = request
                            .getRequestDispatcher("/api/token/refresh");
                    requestDispatcher.forward(request, response);


                }else {
                    RequestDispatcher requestDispatcher = request
                            .getRequestDispatcher("/api/signup");
                    requestDispatcher.forward(request, response);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
