package machine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import machine.data.enums.MachineType;
import machine.services.TestServiceCompresor;

@SpringBootApplication
public class MachineAppApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MachineAppApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner demo(TestServiceCompresor tsc) {
		return (args) -> {
			tsc.insertMachine();
			System.out.println("ALL COMPRESSORS");
			tsc.getAllMachinesByType(MachineType.COMPRESSOR).forEach(c-> System.out.println(c));
			System.out.println("ALL MACHINES");
			tsc.getAllMachines().forEach(m-> System.out.println(m));
			System.out.println("ALL DRYERS");
			tsc.getAllMachinesByType(MachineType.DRYER).forEach(c-> System.out.println(c));
		};
	}
}
