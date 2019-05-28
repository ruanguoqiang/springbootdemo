import com.qiangge.webservice.client.Inceptor.MessageInInterceptor;
import com.qiangge.webservice.client.Inceptor.MessageOutInterCeptor;
import com.qiangge.webservice.client.wsdl.User;
import com.qiangge.webservice.client.wsdl.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Webserviceclient {
    @Test
    public void contextLoads() {
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
    }
}
