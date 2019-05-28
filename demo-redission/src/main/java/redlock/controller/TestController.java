package redlock.controller;

import redlock.util.RedissLockUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TestController {
	
//	private static final Logger LOG = Logger.getLogger(BootApplication.class.getName());
//	LOG.log(Level.INFO, "All procn");


	private final String _lock  = "_lock";
	
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static String getCurrentDate(){
		return sdf.format(new Date());
	}

	@RequestMapping(value = "/testlock",method= RequestMethod.GET)
	public String testlock(String name) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

			//	RedissLockUtil.lock(_lock, TimeUnit.SECONDS, 10);
				RedissLockUtil.lock(_lock);
				
				System.out.println(getCurrentDate()+" "+name+" begin...");
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						System.out.println(getCurrentDate()+" "+name+" "+i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(getCurrentDate()+" "+name+" end...");
				
				RedissLockUtil.unlock(_lock);
			}
		}).start();

		return "testlock";
	}


	
}
