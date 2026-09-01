package in.gvc;

import in.gvc.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath = "";

        String baseDoc = new File("src/main/webApps").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, baseDoc);

        // IOC
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        springContext.register(AppConfig.class);

        // DISPATCHER SERVLET
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);

        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        context.addServletMappingDecoded("/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat Started on port 8080");

        tomcat.getServer().await();

    }
}