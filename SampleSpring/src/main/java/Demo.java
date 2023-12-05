
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AbstractApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		 context.registerShutdownHook();
		 Rectangle rect=(Rectangle) context.getBean("rectangle");
		 rect.draw();
		 System.out.println(context.getMessage("wish1",null,"default msg",null));
		
	}

}
