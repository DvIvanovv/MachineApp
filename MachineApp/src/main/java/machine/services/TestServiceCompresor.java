//package machine.services;
//
//import java.util.Arrays;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import machine.data.entities.machines.Machine;
//import machine.data.entities.machines.compressors.PistonCompressor;
//import machine.data.entities.machines.compressors.ScrewCompressor;
//import machine.data.entities.machines.dryers.AdsorptionDryer;
//import machine.data.entities.machines.dryers.RefrigerationDryer;
//import machine.data.enums.MachineType;
//import machine.data.repository.MachineRepository;
//
//@Service
//@Transactional
//public class TestServiceCompresor {
//
//	private MachineRepository machineRepository;
//	@Autowired
//	public TestServiceCompresor(MachineRepository machineRepository) {
//		super();
//		this.machineRepository = machineRepository;
//	}
//	public void insertMachine() {
//		ScrewCompressor screwCompressor = new ScrewCompressor();
//		PistonCompressor pistonCompressor = new PistonCompressor();
//		AdsorptionDryer ad = new AdsorptionDryer();
//		RefrigerationDryer rf = new RefrigerationDryer();
//		screwCompressor.setMachineType(MachineType.SCREW_COMPRESSOR);
//		screwCompressor.setDimension("1x2x3");
//		screwCompressor.setModel("SCK-75");
//		screwCompressor.setPower(25.00);
//		screwCompressor.setPowerConsumption(11.11);
//		screwCompressor.setVolumeAt10Bars(10.00);
//		screwCompressor.setVolumeAt13Bars(13.00);
//		screwCompressor.setVolumeAt8Bars(8.00);
//		screwCompressor.setWeigth(112.00);
//		pistonCompressor.setMachineType(MachineType.PISTON_COMPRESSOR);
//		pistonCompressor.setDimension("1x1x1");
//		pistonCompressor.setModel("ALS-10");
//		pistonCompressor.setNumberOfPistons((short)1);
//		pistonCompressor.setNumberOfstage((short)2);
//		pistonCompressor.setPower(10.0);
//		pistonCompressor.setPowerConsumption(1.5);
//		pistonCompressor.setWeigth(10.00);
//		ad.setMachineType(MachineType.ADSORPTION_DRYER);
//		ad.setDimension("11x11x11");
//		ad.setModel("AD-17");
//		ad.setPower(1.5);
//		ad.setPowerConsumption(1.2);
//		ad.setWeigth(100.0);
//		ad.setCompressedAirConnection("5/6");
//		ad.setVolumetricFlowRate(33.6);
//		rf.setMachineType(MachineType.REFRIGERATION_DRYER);
//		rf.setDimension("22x21x21");
//		rf.setModel("RF-15");
//		rf.setPower(1.4);
//		rf.setPowerConsumption(1.2);
//		rf.setWeigth(100.0);
//		rf.setCompressedAirConnection("2/3");
//		rf.setVolumetricFlowRate(33.6);
//
//
//		this.machineRepository.save(screwCompressor);
//		this.machineRepository.save(pistonCompressor);
//		this.machineRepository.save(ad);
//		this.machineRepository.save(rf);
//
//
//	}
//	public List<Machine> getAllMachines() {
//		return (List<Machine>)this.machineRepository.findAll();
//
//	}
//	public List<Machine> getAllMachinesByType(MachineType machineType) {
//		//return (List<Machine>)this.machineRepository.findAllByMachineType(machineType);
//		return this.machineRepository.findAllByMachineIdentifierIn(
//				Arrays.asList("Piston", "Adsorbtion"));
//	}
//
//
//
//
//
//
//}
