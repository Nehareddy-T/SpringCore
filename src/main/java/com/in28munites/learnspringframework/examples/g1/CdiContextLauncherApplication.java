package com.in28munites.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28munites.learnspringframework.game.GameRunner;
import com.in28munites.learnspringframework.game.GamingConsole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Component
class BusinessService
{
	private DataService dataService;

	public DataService getDataService() {
		
		return dataService;
	}
	@Autowired
	public void setDataService(DataService dataService) {
		System.out.println("setter");
		this.dataService = dataService;
	}

}

@Component
class DataService{
	
}


@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessService.class).getDataService());
//		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
