package com.in28munites.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28munites.learnspringframework.game.GameRunner;
import com.in28munites.learnspringframework.game.GamingConsole;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Component
class SomeClass{

	private SomeDependency depndency;

	public SomeClass(SomeDependency depndency) {
		super();
		this.depndency = depndency;
		System.out.println("sanjay");
	}
	
	@PostConstruct
	public void initialize() {
		depndency.getReady();
	}
	
	@PreDestroy
	public void cleanup() {
		System.out.print("\nCleanup");
	}
	
	
	
}
@Component
class SomeDependency{
	public void getReady() {
		
		System.out.println("someDependency");
		
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLaunchApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLaunchApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
