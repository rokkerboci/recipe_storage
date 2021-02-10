package hu.sssl.fozos.web.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfigurer : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var authenticationEntryPoint: Q10AuthenticationEntryPoint

    @Autowired
    private lateinit var userDetailsService: Q10UserDetailsService

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
    }

    override fun configure(http: HttpSecurity) {
        http
            .logout().logoutUrl("/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID").invalidateHttpSession(true)
            .clearAuthentication(true)
            .and().formLogin()
            .and()
            .authorizeRequests()
//            .antMatchers(HttpMethod.GET,"/admin").hasAuthority(Q10User.DELETE_CONTENT)
//            .antMatchers(HttpMethod.DELETE,"/posts/{post_id}").hasAuthority(Q10User.DELETE_CONTENT)
//            .antMatchers( "/users/register").permitAll()
//            .antMatchers( "/login").permitAll()
            .antMatchers( /*HttpMethod.GET,*/"/**").permitAll()
            .anyRequest().authenticated()
            .and().headers()
            .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)
            .and().csrf().disable()
    }

    @Bean
    fun encoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
