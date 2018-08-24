package machine;

import java.util.concurrent.Executor;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import machine.data.entities.machines.compressors.PistonCompressor;
import machine.data.entities.machines.compressors.ScrewCompressor;
import machine.data.entities.machines.dryers.AdsorptionDryer;
import machine.data.entities.machines.dryers.RefrigerationDryer;
import machine.dto.MachineDto;
import machine.dto.ScrewCompressorDto;
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
		registry.addConverter(MachineDto.class, String.class, new Converter<MachineDto, String>() {
            @Override
            public String convert(MachineDto source) {
                return source.getId().toString();
            }
        });
		registry.addConverter(ScrewCompressor.class, String.class, new Converter<ScrewCompressor, String>() {
            @Override
            public String convert(ScrewCompressor source) {
                return source.getId().toString();
            }
        });
		registry.addConverter(PistonCompressor.class, String.class, new Converter<PistonCompressor, String>() {
            @Override
            public String convert(PistonCompressor source) {
                return source.getId().toString();
            }
        });
		registry.addConverter(RefrigerationDryer.class, String.class, new Converter<RefrigerationDryer, String>() {
            @Override
            public String convert(RefrigerationDryer source) {
                return source.getId().toString();
            }
        });
		registry.addConverter(AdsorptionDryer.class, String.class, new Converter<AdsorptionDryer, String>() {
            @Override
            public String convert(AdsorptionDryer source) {
                return source.getId().toString();
            }
        });
		
	}

	@Bean
	public ModelMapper createModelMapper(){
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
