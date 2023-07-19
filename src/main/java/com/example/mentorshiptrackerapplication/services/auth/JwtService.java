package com.example.mentorshiptrackerapplication.services.auth;

import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public interface JwtService {


    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(UserRequestDTO userRequestDTO);

    String generateToken(
            Map<String, Object> extraClaims,
            UserRequestDTO userRequestDTO

    );

    boolean isTokenValid(String token, UserDetails userDetails);


}
