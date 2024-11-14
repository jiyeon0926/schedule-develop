package shcedule;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shcedule.filter.LoginFilter;
import shcedule.repository.UserRepository;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean loginFilter(UserRepository userRepository) {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        // filter 등록
        filterRegistrationBean.setFilter(new LoginFilter(userRepository));
        // filter 순서 설정
        filterRegistrationBean.setOrder(1);
        // filter 적용할 url 지정
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
