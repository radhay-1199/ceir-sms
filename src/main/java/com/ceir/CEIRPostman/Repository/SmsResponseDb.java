package com.ceir.CEIRPostman.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SmsResponseDb {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertDetails(String msisdn,String text,String messageId) {
		try {
			logger.info("Inserting response into sms_resp_db table => mobile_number: "+msisdn+", message: "+text+", messageId: "+messageId);
			String query="insert into sms_resp_db(mobile_number,message,message_id) values('"+msisdn+"','"+text+"','"+messageId+"')";
			logger.info("query: "+query);
			jdbcTemplate.execute(query);
			return 1;
		} catch (Exception e) {
			logger.info("exception while inserting new entry for sms_resp_db : "+e);
			e.printStackTrace();
			return 0;
		}
	}
}
