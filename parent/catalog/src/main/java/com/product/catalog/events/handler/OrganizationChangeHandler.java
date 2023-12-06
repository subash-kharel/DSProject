package com.product.catalog.events.handler;


import com.product.catalog.events.CustomChannels;
import com.product.catalog.events.model.OrganizationChangeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(CustomChannels.class)
public class OrganizationChangeHandler {

    private static final Logger logger = LoggerFactory.getLogger(OrganizationChangeHandler.class);

    @StreamListener("inboundOrgChanges")
    public void loggerSink(OrganizationChangeModel organization) {
    	
        logger.debug("Received a message of type " + organization.getType());
        logger.debug("Received a message with an event {} from the organization service for the organization id {} ", 
        		organization.getType(), organization.getType());
    }


}
