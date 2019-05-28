package com.qiangge.webservice.client.Inceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

@Slf4j
public class MessageInInterceptor extends AbstractPhaseInterceptor<Message>{

	public String uuid;
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public MessageInInterceptor(String phase,String uuid) {
		super(phase);
		this.uuid = uuid;
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		log.info("接收ilog返回时间===="+uuid+"====="+System.currentTimeMillis());
		System.out.println("接收ilog返回时间===="+uuid+"====="+System.currentTimeMillis());
	}

}
