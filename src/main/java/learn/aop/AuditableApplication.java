package learn.aop;

import learn.aop.model.DemoEntity;
import learn.aop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuditableApplication implements CommandLineRunner {

    private DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        demoService.save(new DemoEntity(1, "new description"));
    }

    public static void main(String[] args) {
        SpringApplication.run(AuditableApplication.class, args);
    }

   @Autowired
   public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }
}
