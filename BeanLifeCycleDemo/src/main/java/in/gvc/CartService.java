package in.gvc;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CartService implements BeanNameAware, ApplicationContextAware
        /*implements InitializingBean, DisposableBean*/ {

    HashMap<Integer, String> mp;

    public CartService(){
        mp = new HashMap<>();
        System.out.println("Cart Service Called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name :" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext.getDisplayName());
    }


    @PostConstruct
    public void start(){
        System.out.println("Bean is ready");
        mp.put(1, "Ram");
        mp.put(2, "Hanuman");
    }

    public void addToCart() {
        System.out.println("Added to Cart");
    }

    public String getValue(int key) {
        return mp.get(key);
    }



//    @Override
//    public void destroy() throws Exception {
//        mp.clear();
//        System.out.println("Bean is getting Destroyed");
//    }
    @PreDestroy
    public void stop() {
        mp.clear();
        System.out.println("Bean is getting Destroyed");
    }


//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Bean is ready");
//        mp.put(1, "Ram");
//        mp.put(2, "Hanuman");
//    }




}
