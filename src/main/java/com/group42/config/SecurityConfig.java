//package com.group42.config;
//
//import com.group42.filter.JwtAuthorizationTokenFilter;
//import com.group42.security.JwtAccessDeniedHandler;
//import com.group42.security.JwtAuthenticationEntryPoint;
//import com.group42.security.JwtUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//@EnableWebSecurity// 这个注解必须加，开启Security
//@EnableGlobalMethodSecurity(prePostEnabled = true)//保证post之前的注解可以使用
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Autowired
//    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
//
//    @Autowired
//    private JwtUserDetailsService jwtUserDetailsService;
//
//    @Autowired
//    private JwtAuthorizationTokenFilter authenticationTokenFilter;
//
//
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoderBean());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.headers().frameOptions().disable();
//
//        http.csrf().disable()
//                .cors()
//                .and()
//                .authorizeRequests()
//
//                .antMatchers("/login").permitAll()
//                .antMatchers("/single/oa/login").permitAll()
//                .antMatchers("/logout").permitAll()
//                .antMatchers("/wechat/**").permitAll()
//                .antMatchers("/mb/image/**").permitAll()
//                .antMatchers("/druid/**").permitAll()
//                .antMatchers("/common/download").permitAll()
//                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
//                .anyRequest().authenticated()       // 剩下所有的验证都需要验证
//                .and()
//                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .exceptionHandling().accessDeniedHandler(jwtAccessDeniedHandler)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // 定制我们自己的 session 策略：调整为让 Spring Security 不创建和使用 session
//        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoderBean() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//}
