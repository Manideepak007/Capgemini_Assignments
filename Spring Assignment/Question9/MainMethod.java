package Question9;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Q9.xml");
		
		context.registerShutdownHook();
		BeanLIfeCycle BLC = (BeanLIfeCycle) context.getBean("details1");
		
		BLC.display();
	}

}
