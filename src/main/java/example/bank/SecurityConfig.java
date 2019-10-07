package example.bank;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static example.bank.Saml2Configuration.relyingPartyRegistrationRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests ->
                        requests.anyRequest().authenticated()
                )
                .saml2Login(c ->
                        c.relyingPartyRegistrationRepository(relyingPartyRegistrationRepository())
                );
    }
}