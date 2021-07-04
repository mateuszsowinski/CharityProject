package pl.sowinski.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.sowinski.charity.user.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public CustomUserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/app/**").authenticated()
                .anyRequest()
                .permitAll()

                .and()
                .formLogin().loginPage("/login").usernameParameter("userName").successHandler(myAuthenticationSuccessHandler())
                .permitAll().and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll()
                .and().cors().and().csrf().disable();

    }
}
// http.authorizeRequests()
//         .antMatchers("/app/**")
//         .authenticated()
//         .anyRequest()
//         .permitAll()
//
//         .and()
//         .formLogin().loginPage("/login").usernameParameter("userName").successHandler(myAuthenticationSuccessHandler())
//         .permitAll().and()
//         .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();


//     http.authorizeRequests()
//                .antMatchers("/app/**").authenticated()
//                .antMatchers("/admin/**").authenticated()
//                .antMatchers("/css/**", "/images/**", "/js/**").permitAll()
//                .anyRequest()
//                .permitAll()
//
//                .and()
//                .formLogin().loginPage("/login").usernameParameter("userName").successHandler(myAuthenticationSuccessHandler())
//                .permitAll().and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();