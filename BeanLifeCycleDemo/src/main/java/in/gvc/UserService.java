package in.gvc;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

//@Component
public class UserService implements BeanNameAware {

    public UserService(){
        System.out.println("User Service Created");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name :" + name);
    }
}
