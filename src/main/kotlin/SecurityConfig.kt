import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun userDetailsService(): UserDetailsService {
        val userDetailsManager = InMemoryUserDetailsManager()
        val userEditor = User.withUsername("editor")
            .password("password")
            .roles("EDITOR")
            .build()
        val userViewer = User.withUsername("viewer")
            .password("password")
            .roles("VIEWER")
            .build()

        userDetailsManager.createUser(userEditor)
        userDetailsManager.createUser(userViewer)

        return userDetailsManager
    }

    fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
    }
}


