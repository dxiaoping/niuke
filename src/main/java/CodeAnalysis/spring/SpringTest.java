package CodeAnalysis.spring;

import CodeAnalysis.spring.service.StudentService;
import CodeAnalysis.spring.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-26 9:56
 */
public class SpringTest {

//    @Autowired
//    UserService userService;

    @Test
    public void testGetBean() {
        String path = "spring/spring-config.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.getUser());

        StudentService studentService = context.getBean("studentService", StudentService.class);
        System.out.println(studentService.getUser());
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

    }
    //code study case
    @Test
    public void test2() {
        String path = "spring/spring-config.xml";
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource(path));
        UserService userService = bf.getBean("userService", UserService.class);
        System.out.println(userService.getUser());
    }


    @Test
    public void testBeanDefinitionReader() {
        String path = "spring/spring-config.xml";
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

        //new ClassPathResource(path)
        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource(path);

        //new XmlBeanFactory执行
        reader.loadBeanDefinitions(resource);

        BeanDefinition beanDefinition = registry.getBeanDefinition("userService");
        System.out.println();
        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

    }

    @Test
    public void testBeanDefinitionReader1() {
        String path = "spring/spring-config.xml";
        //对比ApplicationContext
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        DefaultResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource(path);
        reader.loadBeanDefinitions(resource);


        UserService userService = factory.getBean("userService", UserService.class);
        System.out.println(userService.getUser());
        System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));

    }
}
