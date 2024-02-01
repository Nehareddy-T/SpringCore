package com.in28munites.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28munites.learnspringframework.game.GameRunner;
import com.in28munites.learnspringframework.game.GamingConsole;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



public class XmlConfigurationContextLaunchApplication {
	
	
	public static void main(String args[]) {
		
		try (var context = new ClassPathXmlApplicationContext("context.xml")) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
