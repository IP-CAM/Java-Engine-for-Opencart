package br.com.fatecmogidascruzes.security.service;

import br.com.fatecmogidascruzes.dao.impl.UserDAO;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

    // Frase para misturara com o gerador de token (salt):
    private final String secret = "SequenciaDeCaracteresParaAssinarToken";

	// Tempo de expiração do tokon em milissegundos
    // private final Long expiration = 3600000L;
    private final Long expiration = 86400000000L;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public boolean tokenValido(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            String matchusername = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            TableUser user = getCurrentUserName(matchusername);
            if (user.getUsername().equals(matchusername) && expirationDate != null && now.before(expirationDate)) {
                return true;
            }
        }
        return false;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }
    
    public Date getExpirationDate(String token){
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getExpiration();
        }
        return null;
        
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }
    private TableUser getCurrentUserName(String username){
        UserDAO userDao = new UserDAO();
        TableUser user = (TableUser)userDao.findByUserName(username);
        return user;
        
    }
    
}
