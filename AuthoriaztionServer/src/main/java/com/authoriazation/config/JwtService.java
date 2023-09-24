package com.authoriazation.config;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;

@Component
public class JwtService {

	public static final String SECRECT = "dgjorufhrsnjdu438fkdj38fdmcv7dm3ckvhrsnjjuwelueivhe848fhedldh5ndk";

	public boolean validateToken(final String jwtToken) {
			System.out.println("token ************ "+jwtToken);
			try {
				String subject = Jwts.parser().setSigningKey(SECRECT
						         .getBytes(Charset.forName("UTF-8")))
								 .parseClaimsJws(jwtToken.replace("{", "")
								 .replace("}",""))
								 .getBody().getSubject();			
				if (subject == null || subject.isEmpty()) {
					return false;
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
	}

	private byte[] getSigningKey() {
		return Decoders.BASE64.decode(SECRECT);
	}
	
	public String generateToken(String email) {
		Map<String,Object> map = new HashMap<String,Object>();
		return createToken(map,email);
	}

	private String createToken(Map<String, Object> claims, String email) {
		
		
		
		String token =  Jwts.builder().setSubject(email).setIssuedAt(new Date(System.currentTimeMillis()))
		        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 1000))
		        .signWith(SignatureAlgorithm.HS512, SECRECT.getBytes(Charset.forName("UTF-8"))).compact();

		return token;
				// add token in header
				//res.addHeader("tocken", token);
				//res.addHeader("userId", user.getUserId());
		
		
	}
}
