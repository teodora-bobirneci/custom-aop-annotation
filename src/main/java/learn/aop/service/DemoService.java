package learn.aop.service;

import learn.aop.model.DemoEntity;
import learn.aop.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired private DemoRepository demoRepository;

    public void save(DemoEntity demoEntity){
        demoRepository.save(demoEntity);
    }
}
