package machine;

import java.util.concurrent.Executor;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import machine.data.entities.machines.Machine;
import machine.dto.MachineDto;
import machine.interceptors.CounterInterceptor;
import machine.interceptors.IpInterceptor;
import machine.interceptors.LoggerInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new CounterInterceptor()).addPathPatterns("/");
		registry.addInterceptor(new IpInterceptor()).addPathPatterns("/");
		registry.addInterceptor(new LoggerInterceptor());
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		WebMvcConfigurer.super.addFormatters(registry);
//		registry.addConverter(Machine.class, String.class, new Converter<Machine, String>() {
//                @Override
//                public String convert(Machine source) {
//                    return source.getId().toString();
//                }
//            });
		registry.addConverter(MachineDto.class, String.class, new Converter<MachineDto, String>() {
            @Override
            public String convert(MachineDto source) {
                return source.getId().toString();
            }
        });
		
	}

	@Bean
	public ModelMapper createModelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		return new ModelMapper();
	}
	
	@Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(40);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }
	

	
//	TODO add additional configuration, e.g. security
}
