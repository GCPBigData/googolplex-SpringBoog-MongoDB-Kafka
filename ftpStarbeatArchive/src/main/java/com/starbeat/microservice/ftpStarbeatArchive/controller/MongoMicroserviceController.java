package com.starbeat.microservice.ftpStarbeatArchive.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starbeat.microservice.ftpStarbeatArchive.dal.dao.MicroserviceLogDao;
import com.starbeat.microservice.ftpStarbeatArchive.dal.model.MicroserviceLog;

@RestController
public class MongoMicroserviceController {

	private static final String METER_SERIAL_NUMBER = "METER_SERIAL_NUMBER";
	private static final String FTP_MICROSERVICE = "FTP_MICROSERVICE";

	@Autowired
	MicroserviceLogDao microserviceLogDao;

	@PostMapping(value = "/log")
	public void logToMongoBd() {
		MicroserviceLog microserviceLog = new MicroserviceLog();
		LocalDateTime ldt = LocalDateTime.now();
		microserviceLog.setTime(ldt);
		microserviceLog.setMeterSerialNumber(METER_SERIAL_NUMBER);
		microserviceLog.setMicroserviceName(FTP_MICROSERVICE);
		this.microserviceLogDao.save(microserviceLog);
	}
}
