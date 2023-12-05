import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class DemoBeanPP implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		//return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		System.out.println("Before Initialize bean name "+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		//return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
		System.out.println("After Initialize bean name "+beanName);
		return bean;
	
	}
	

}
