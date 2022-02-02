package com.sha.springbootmicroservice2transaction.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity // web tabanlı güvenlik sağlamak için
                    // WebSecurityConfigurerAdapter kullanilacak
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        // acik metinle degil hashing ile saklamak
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // Bilgiler hashing ile saklanabilir.
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser(SECURE_KEY_USERNAME)
                .password(encoder.encode(SECURE_KEY_PASSWORD))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        super.configure(httpSecurity);

        // saldirgan sesion degerini web guvenlik acigi olarak kullanabilir
        // ancak biz burada session kimlik dogrulamasi kullanmayacagiz
        httpSecurity.csrf().disable();

        // test senaryosu icin h2 consola eirisilecek
//        httpSecurity.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated();

        // h2 veritabanı spring boot sayfalarını iframe olark kullanir
        // ancak spring security buna izin vermez
        // etkinlestirmek icin bu korumayi devre sisi birakma veya
        // frame'leri ayni origin'de gostermek
//       httpSecurity.headers().frameOptions().sameOrigin();
    }
}
