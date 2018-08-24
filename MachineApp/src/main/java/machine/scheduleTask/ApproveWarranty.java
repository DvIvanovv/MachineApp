package machine.scheduleTask;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import machine.data.entities.Warranty;
import machine.services.RgisterWarrantyService;

@Component
public class ApproveWarranty {
	private static final Logger logg =  LoggerFactory.getLogger(ApproveWarranty.class);

	private RgisterWarrantyService warrantyService;
	@Autowired
	public ApproveWarranty(RgisterWarrantyService warrantyService) {
		super();
		this.warrantyService = warrantyService;
	}

	@Scheduled( cron = "0 0 6 * * *")//fixedRate = 5000// every day 06:00
	public void approveWarranties() {
		int counter = 0;
		List<Warranty> warranties = this.warrantyService.getAllWarranties();
		if(warranties.size() > 0) {
			for(Warranty w : warranties) {
				counter++;
				if(!w.getIsApproved())
				w.setIsApproved(true);
				this.warrantyService.approvedWarranty(w);
			}
		}
		 logg.info("Waaranties approved: " + counter);
	}

}
