package com.qiangge.webservice.client.test;

import com.qiangge.webservice.client.Inceptor.MessageInInterceptor;
import com.qiangge.webservice.client.Inceptor.MessageOutInterCeptor;
import com.qiangge.webservice.client.wsdl.User;
import com.qiangge.webservice.client.wsdl.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {

    @GetMapping(value = "testClient")
    public String testWebservice(){
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:9004/service/user?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(UserService.class);

        jaxWsProxyFactoryBean.getOutInterceptors().add(new MessageOutInterCeptor(Phase.SEND,"awdadawad"));
        jaxWsProxyFactoryBean.getInInterceptors().add(new MessageInInterceptor(Phase.RECEIVE, "awdadawad"));

        UserService userService = (UserService) jaxWsProxyFactoryBean.create(); // 创建客户端对象
        Client proxy= ClientProxy.getClient(userService);
        HTTPConduit conduit=(HTTPConduit)proxy.getConduit();
        HTTPClientPolicy policy=new HTTPClientPolicy();
        policy.setConnectionTimeout(1000);
        policy.setReceiveTimeout(1000);
        conduit.setClient(policy);

        User userResult= userService.getUser("411001");
        System.out.println("UserName:"+userResult.getUsername());
        ArrayList<User> users=(ArrayList<User>) userService.getAlLUser();
        System.out.println(users);
        return "sucess";
    }

    @GetMapping(value = "testClient2")
    public String testWebservice2(){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:9004/service/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getName", "qiangge");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
