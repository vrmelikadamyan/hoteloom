//package com.vmelik.client.config.security;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {
//    private static final String REALM_ACCESS_CLAIM = "realm_access";
//    private static final String ROLES_CLAIM = "roles";
//    private static final String ROLE_PREFIX = "ROLE_";
//
//    @Override
//    public AbstractAuthenticationToken convert(Jwt jwt) {
//        return new JwtAuthenticationToken(jwt, extractAuthorities(jwt));
//    }
//
//    private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
//        if (jwt.getClaim(REALM_ACCESS_CLAIM) != null) {
//            Map<String, Object> realmAccess = jwt.getClaimAsMap(REALM_ACCESS_CLAIM);
//            ObjectMapper mapper = new ObjectMapper();
//
//            List<String> roles = mapper.convertValue(realmAccess.get(ROLES_CLAIM), new TypeReference<>() {
//            });
//
//            List<GrantedAuthority> authorities = new ArrayList<>();
//            for (String role : roles) {
//                authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
//            }
//
//            return authorities;
//        }
//
//        return new ArrayList<>();
//    }
//}
