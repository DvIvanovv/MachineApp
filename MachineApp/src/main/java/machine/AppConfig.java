package machine;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}
	
//	TODO add additional configuration, e.g. security
}
