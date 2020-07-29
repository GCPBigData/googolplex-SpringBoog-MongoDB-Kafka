package com.googolplex.dal.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.googolplex.dal.model.MicroserviceLog;

@Service
public interface MicroserviceLogDao extends MongoRepository<MicroserviceLog, String> {

}