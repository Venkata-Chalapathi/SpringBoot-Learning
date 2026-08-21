package in.gvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {

    private A a;

    public void setA(A a) {
        this.a = a;
    }
}
