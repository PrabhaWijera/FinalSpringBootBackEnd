package com.example.user_server.user.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class  JwtService {

  private final String SECRET_KEY = "cuLaWpmPGLf6fr/DKhUpcCGur9kD/cTasCeogdLrj7vxqDUQy/QSmj/gxMYZ1Ib4E2lLsRXFbtLm7y60J0jFCg13AMW9JDPjeHV63TTcjkcJqVxDFsAvyGfELwP+HEqcRpwdQ2Nm4Ora7aORyQ1hv/VslhRDqst9gQJAZDainC0raFJoTHEVjiP79ddrj9/VYh0crkdzq6un01sNPLSXudB3cFeciZQxLspf5ZI5p4ZSIOXGhVDdyU/qE71OreiTs0I94TouLZafn9NBKJOTPpcVnURlM1tqausFOCApf5KKRWCns4Z70J5fYSyeXvhXqj9qLaNoR1M92lDENof6oup1QCbqYLtJUU0WmR2gymw=";

  public String extractUsername(String jwtToken) {
    return extractClaim(jwtToken, Claims::getSubject);
  }

  private Claims extractAllClaims(String jwtToken) {
    return Jwts
            .parserBuilder()
            .setSigningKey(getSecretKey()) // Verifies the signature.
            .build()
            .parseClaimsJws(jwtToken)
            .getBody();
  }

  private Key getSecretKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(jwtToken);
    return claimsResolver.apply(claims);
  }

  public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
    return Jwts.builder()
            .setClaims(claims)
            .setSubject(userDetails.getUsername())
            .signWith(getSecretKey(), SignatureAlgorithm.HS256)
            .setIssuedAt(new Date(System.currentTimeMillis())) // Setting the time of issue of the token.
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Setting the expiration time of the token.
            .compact();
  }

  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  public boolean validateToken(String jwtToken, UserDetails userDetails) {
    final String username = extractUsername(jwtToken);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
  }

  private boolean isTokenExpired(String jwtToken) {
    return extractExpiration(jwtToken).before(new Date());
  }

  private Date extractExpiration(String jwtToken) {
    return extractClaim(jwtToken, Claims::getExpiration);
  }
}
