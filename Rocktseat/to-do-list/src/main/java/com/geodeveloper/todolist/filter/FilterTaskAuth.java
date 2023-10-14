package com.geodeveloper.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.geodeveloper.todolist.repository.IUserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var servletPath =  request.getServletPath();

                if (servletPath.startsWith("/tasks/")) {

                        //pega a autenticação (user and password)
                    var authorization = request.getHeader("Authorization");

                    var user_password = authorization.substring("Basic".length()).trim();

                    byte[] authDecode =  Base64.getDecoder().decode(user_password);

                    var authString =  new String(authDecode);

                    String[] credentials =  authString.split(":");
                    String username = credentials[0];
                    String password = credentials[1];

                    //validar o user
                    var user = this.userRepository.findByUserName(username);

                    if (user == null) {
                        response.sendError(401);
                    } else {
                            //validar o password
                            var passwordVeryfy = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());

                            if (passwordVeryfy.verified) {
                                request.setAttribute("iduser", user.getId()); //envia o id do usuária para controller
                                filterChain.doFilter(request, response);
                            } else {
                                response.sendError(401);
                            }
                    
                    }

                    
                } else {
                    
                    filterChain.doFilter(request, response);
                }
       
            }

   
    
}
