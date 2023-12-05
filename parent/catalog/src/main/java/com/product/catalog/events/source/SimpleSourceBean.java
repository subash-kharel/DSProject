package com.product.catalog.events.source;

import com.product.catalog.utils.ActionEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import com.product.catalog.utils.UserContext;

@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishOrganizationChange(ActionEnum action, String organizationId){
       logger.debug("Sending Kafka message {} for Organization Id: {}", action, organizationId);
        main.java.com.product.catalog.events.model.OrganizationChangeModel change =  new main.java.com.product.catalog.events.model.OrganizationChangeModel(
                main.java.com.product.catalog.events.model.OrganizationChangeModel.class.getTypeName(),
                action.toString(),
                organizationId,
                UserContext.getCorrelationId());

        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
