package com.qiangge.webservice.client.Inceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

@Slf4j
public class MessageOutInterCeptor extends AbstractPhaseInterceptor<Message>{
	public String uuid;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public MessageOutInterCeptor(String phase, String uuid) {
		super(phase);
		this.uuid = uuid;
	}
	public void handleMessage(Message arg0) throws Fault {
		System.out.println("请求ilog时间======"+uuid+"===="+System.currentTimeMillis());
		log.info("请求ilog时间======"+uuid+"===="+System.currentTimeMillis());
	}
}
