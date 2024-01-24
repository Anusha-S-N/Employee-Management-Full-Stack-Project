package net.anushasn.ems.config;


import javax.sql.DataSource;

//import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
//
public class SecurityConfig{ 

//extends WebSecurityConfigurerAdapter {
//	
//	 @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests()
//	            .antMatchers("/register", "/login").permitAll()
//	            .antMatchers("/admin/**").hasRole("admin")
//	            .antMatchers("/manager/**").hasRole("manager")
//	            .antMatchers("/employee/**").hasRole("employee")
//	            .and().formLogin();
//	    }

//
//@Bean
//public UserDetailsManager userDetailsManager(DataSource datasource) {
//    //return new JdbcUserDetailsManager(datasource);
//    JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(datasource);
//
//    userDetailsManager.setUsersByUsernameQuery(
//                        "select name, pass, enabled from users where name = ?");
//    userDetailsManager.setAuthoritiesByUsernameQuery(
//        "select name, role from authorities where name = ?"
//    );
//
//    return userDetailsManager;
//}
//
//@Bean
//public SecurityFilterChain filter(HttpSecurity http) throws Exception {
//    http.authorizeHttpRequests(configurer ->
//            configurer
//            .requestMatchers(HttpMethod.GET,"/api/employees").hasAnyRole("Employee","Manager","Admin")
//            .requestMatchers(HttpMethod.GET, "/api/employees/{employeeId").hasAnyRole("Employee","Manager","Admin")
//            .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("Manager","Admin")
//            .requestMatchers(HttpMethod.PUT, "/api/employees/{employeeId}").hasAnyRole("Manager","Admin")
//            .requestMatchers(HttpMethod.DELETE, "/api/employees/{employeeId}").hasRole("Manager")
//            .requestMatchers(HttpMethod.GET, "/updateStudent/allStudents").hasAnyRole("Admin","Manager","normal")
//            .requestMatchers(HttpMethod.POST, "/updateStudent/allStudents").hasAnyRole("Admin","Manager"));
//    http.httpBasic(Customizer.withDefaults());
//    http.csrf(csrf -> csrf.disable());
//    return http.build();
//}

public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // Replace with the actual origin of your React app
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*")
            .allowCredentials(true);
}
}
