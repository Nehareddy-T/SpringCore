package com.in28munites.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.in28munites.learnspringframework.game.GameRunner;
import com.in28munites.learnspringframework.game.GamingConsole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Component
class ClassA{
	
}
@Component
@Lazy
class ClassB{
	private ClassA classA;

	public ClassB(ClassA classA) {
		super();
		System.out.println("Logic");
		this.classA = classA;
	}
		
		public void doSomething() {
			System.out.println("method in classB");
		
		
	}
	
	
}


@Configuration
@ComponentScan
public class LazyIntializationLaunchApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new AnnotationConfigApplicationContext(LazyIntializationLaunchApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println("Intialization of context");
			context.getBean(ClassB.class).doSomething();
//		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
