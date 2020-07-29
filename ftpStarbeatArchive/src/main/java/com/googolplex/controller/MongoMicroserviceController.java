package com.googolplex.controller;

import java.time.LocalDateTime;

import com.googolplex.dal.dao.MicroserviceLogDao;
import com.googolplex.dal.model.MicroserviceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
