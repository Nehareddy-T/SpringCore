package com.in28munites.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.in28munites.learnspringframework.game.GameRunner;
import com.in28munites.learnspringframework.game.GamingConsole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Component
class Normal
{
	
}
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Prototype{
	
}

@Configuration
@ComponentScan
public class BeanScopesLaunchApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new AnnotationConfigApplicationContext(BeanScopesLaunchApplication.class)) {
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Normal.class));
			System.out.println(context.getBean(Prototype.class));
			System.out.println(context.getBean(Prototype.class));
			
//		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
