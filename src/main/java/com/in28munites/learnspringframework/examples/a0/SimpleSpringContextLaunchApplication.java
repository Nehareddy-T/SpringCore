package com.in28munites.learnspringframework.examples.a0;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28munites.learnspringframework.game.GameRunner;
import com.in28munites.learnspringframework.game.GamingConsole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.in28munites.learnspringframework.examples.a1")
public class SimpleSpringContextLaunchApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextLaunchApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//		
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
