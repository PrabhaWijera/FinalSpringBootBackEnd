package com.example.user_server.user.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.util.WebUtils;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilterConfig extends OncePerRequestFilter {
  public static String JWT_TOKEN;
  @Autowired
  private JwtService jwtService;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private HandlerExceptionResolver handlerExceptionResolver;

/*  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
    System.out.println("This is JWTAuthFilter." + request.getHeader("Authorization"));
    String authHeader = request.getHeader("Authorization");//Extracting the header.
    String jwtToken = null;
    String userName;
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      System.out.println("No token found! - This is UA S.");
      filterChain.doFilter(request, response);
      return;
    }
    jwtToken = authHeader.substring(7);
    JWT_TOKEN = jwtToken;


    try {
      userName = jwtService.extractUsername(jwtToken);
      System.out.println("Username : " + userName);
    } catch (Exception exception) {
      handlerExceptionResolver.resolveException(request, response, null, new RuntimeException("Invalid token : " + exception.getLocalizedMessage()));
      return;

    }
    //Checking of the username's not nullability  and the authentication status of the current user.
    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails user = userDetailsService.loadUserByUsername(userName);
      System.out.println("User : " + user.toString());

      if (jwtService.validateToken(jwtToken, user) && jwtService.getUserRole(jwtToken).equals("user") || jwtService.getUserRole(jwtToken).equals("userAdmin") || jwtService.getUserRole(jwtToken).equals("packageDetailsAdmin") || jwtService.getUserRole(jwtToken).equals("paymentsAdmin")) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        System.out.println("auth status: " + authToken.isAuthenticated());
        System.out.println("Here is user role : " + jwtService.getUserRole(jwtToken));
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);


      }


    }
    filterChain.doFilter(request, response);


  }*/

  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization"); // Extracting the header.
    String jwtToken = null;
    String userName;

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    jwtToken = authHeader.substring(7);

    try {
      userName = jwtService.extractUsername(jwtToken);
      System.out.println("Username: " + userName);
    } catch (Exception exception) {
      handlerExceptionResolver.resolveException(request, response, null, new RuntimeException("Invalid token: " + exception.getLocalizedMessage()));
      return;
    }

    // Checking the username's non-nullability and the authentication status of the current user.
    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      UserDetails user = userDetailsService.loadUserByUsername(userName);
      System.out.println("User: " + user.toString());

      if (jwtService.validateToken(jwtToken, user)) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        System.out.println("Auth status: " + authToken.isAuthenticated());
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);
      }
    }

    filterChain.doFilter(request, response);
  }
}
