package com.intake.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time_api")
public class TimeApiController {
	
		@RequestMapping("/local_time")
		public String getLocalTime() {
			LocalDate localDate = LocalDate.now();
			System.out.println("currentTime 1------->"+localDate.toString());
			return localDate.toString();	
			
		}
		
		@GetMapping(value="/zone_time")
		public String getZoneTime(@RequestParam("zone_id") final String zoneId) {
			System.out.println("zoneId ---------------->"+zoneId);
			ZoneId zone = ZoneId.of(zoneId);
			String zoneTime = LocalDate.now(zone).toString();
			return zoneTime;
		}
		
		@GetMapping(value="/zone_ids")
		public Set<String> getZoneIds(){
			return ZoneId.getAvailableZoneIds();		
		}


}
