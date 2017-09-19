package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import com.jcraft.jsch.KeyPair;

@Configuration
public class MSLoginSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.formLogin().loginPage("/login").permitAll()
		.and().authorizeRequests().anyRequest().authenticated();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.parentAuthenticationManager(authenticationManager);
	}
	
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
		
		@Bean
		public JwtAccessTokenConverter jwtAccessTokenConverter(){
			/*JwtAccessTokenConverter converter=new JwtAccessTokenConverter();
			KeyPair keyPair=new KeyStoreKeyFactory(new ClassPathResource("keystroke.jks"), "foobar".toCharArray());
*/			return null;
		}
		
		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// TODO Auto-generated method stub
			clients.inMemory().withClient("sg").secret("admin@123").authorizedGrantTypes("autorization_code","refresh_token","password").scopes("openid");
		}
		
		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter());
		}
		
		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated");
		}
	}
	
	
}
