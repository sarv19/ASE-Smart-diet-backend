//package com.group42.security;
//
//
//import com.mtrsz.common.data.SessionUser;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Clock;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.DefaultClock;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cglib.core.internal.Function;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class JwtTokenUtil implements Serializable {
//    private static final long serialVersionUID = -3301605591108950415L;
//
//    @Value("${jwt.token}")
//    private String tokenHeader;
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//
//    private Clock clock = DefaultClock.INSTANCE;
//
//    public String generateToken(SessionUser userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return doGenerateToken(claims, userDetails.getUserName());
//    }
//
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        final Date createdDate = clock.now();
//        final Date expirationDate = calculateExpirationDate(createdDate);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(createdDate)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    private Date calculateExpirationDate(Date createdDate) {
//        return new Date(createdDate.getTime() + expiration*1000*60);
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        SecurityUserDetails user = (SecurityUserDetails) userDetails;
//        final String username = getUsernameFromToken(token);
//        return (username.equals(user.getUsername())
//                && !isTokenExpired(token)
//        );
//    }
//
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//
//    private Boolean isTokenExpired(String token) {
//        final Date expirationDate = getExpirationDateFromToken(token);
//        return expirationDate.before(clock.now());
//    }
//
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//}
