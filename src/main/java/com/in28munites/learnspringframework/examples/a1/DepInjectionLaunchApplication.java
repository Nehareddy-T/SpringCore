package com.in28munites.learnspringframework.examples.a1;

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
class YourBusinessClass{
    //@Autowired
	Dependency1 dependency1;
    //@Autowired
	Dependency2 dependency2;
	
	
//	public Dependency1 getDependency1() {
//		return dependency1;
//	}
//    
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter from Dependency1");
//		this.dependency1 = dependency1;
//	}
//
//	public Dependency2 getDependency2() {
//		return dependency2;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter from Dependency2");
//		this.dependency2 = dependency2;
	// @Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor injection yourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	

	@Override
	public String toString() {
		return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
	
	
}
@Component
class Dependency1{
	
}
@Component
class Dependency2{
	
}

@Configuration
@ComponentScan
public class DepInjectionLaunchApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new AnnotationConfigApplicationContext(DepInjectionLaunchApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBusinessClass.class));
//		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
