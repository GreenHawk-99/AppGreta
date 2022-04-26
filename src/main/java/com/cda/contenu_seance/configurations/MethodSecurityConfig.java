package com.cda.contenu_seance.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class MethodSecurityConfig  extends GlobalMethodSecurityConfiguration  {


}