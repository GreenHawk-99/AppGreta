package com.cda.contenu_seance.services;

import com.cda.contenu_seance.models.entities.Coordinateur;
import com.cda.contenu_seance.models.entities.Formateur;
import com.cda.contenu_seance.models.entities.Intervenant;
import com.cda.contenu_seance.models.repositories.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class JPAUserDetailService implements UserDetailsService {

    @Autowired
    private IntervenantRepository intervenantRepository;

    @Bean
    public PasswordEncoder delegatingPasswordEncoder() {
        PasswordEncoder defaultEncoder = new BCryptPasswordEncoder();
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);
        passworEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);

        return passworEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Intervenant intervenant = intervenantRepository.findByEmail(email);
        if(null==intervenant){
            throw  new UsernameNotFoundException("Intervenant introuvable");
        }
        Coordinateur coordinateur = new Coordinateur();
        Formateur formateur = new Formateur();
        Set<GrantedAuthority> listeDePermissions = new HashSet<GrantedAuthority>();
        listeDePermissions.add(new SimpleGrantedAuthority(coordinateur.getClass().getSimpleName()));
        listeDePermissions.add(new SimpleGrantedAuthority(formateur.getClass().getSimpleName()));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123");
            System.out.println(password);
            System.out.println("PASSWORD = "+encoder.encode(intervenant.getMdp()));;
        return new User(intervenant.getEmail(),intervenant.getMdp(),listeDePermissions);

    }
}