package com.cdac.springbootapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.springbootapp.Passenger.Gender;
import com.cdac.springbootapp.Passenger.Status;

@RestController
@CrossOrigin
public class PnrController {

	@GetMapping("/pnr/{pnrno}")
	public Pnr getStatus(@PathVariable int pnrno) {
		//for the time i will hardcode the data and send it
		Pnr pnr = new Pnr();
		pnr.setPnrNo(pnrno);
		pnr.setTrainNo(12345);
		pnr.setTravelDate(LocalDate.of(2023, 8, 10));
		
		List<Passenger> list  = new ArrayList<>();
		
		Passenger passenger1 = new Passenger();
		passenger1.setName("Ram");
		passenger1.setGender(Gender.MALE);
		passenger1.setStatus(Status.RAC);

		Passenger passenger2 = new Passenger();
		passenger2.setName("Shyam");
		passenger2.setGender(Gender.MALE);
		passenger2.setStatus(Status.CONFIRMED);

		list.add(passenger1);
		list.add(passenger2);
		pnr.setPassengers(list);
		
		return pnr;
	}
}
