package com.intake.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time_api")
public class TimeApiController {
	
		@RequestMapping(value = "/local_time", method = RequestMethod.GET)
		public ResponseEntity<String>  getLocalTime() {
			LocalDate localDate = LocalDate.now();
			System.out.println("currentTime 1------->"+localDate.toString());
			return new ResponseEntity<String>(localDate.toString(), HttpStatus.OK);
			
		}
		
		@RequestMapping(value="/zone_time", method = RequestMethod.GET)
		public ResponseEntity<String> getZoneTime(@RequestParam("zone_id") final String zoneId) {
			System.out.println("zoneId ---------------->"+zoneId);
			ZoneId zone = ZoneId.of(zoneId);
			String zoneTime = LocalDate.now(zone).toString();
			return new ResponseEntity<String>(zoneTime, HttpStatus.OK);
		}
		
		@RequestMapping(value="/zone_ids", method = RequestMethod.GET)
		public ResponseEntity<Set<String>> getZoneIds(){
			return new ResponseEntity<Set<String>>(ZoneId.getAvailableZoneIds(), HttpStatus.OK);		
		}


}
