package learn.aop;

import learn.aop.model.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Aspect
@Component
public class AuditingAspect implements ApplicationContextAware {

    private ApplicationContext appplicationContext;

    @After("execution(* learn.aop.repository.*Repository.save(..))")
    public void audit(JoinPoint joinPoint) throws Throwable {
        try {
            BaseEntity updatedEntity = (BaseEntity) joinPoint.getArgs()[0];
            log.info("joinPoint args: {}", updatedEntity);

            Class aClass = joinPoint.getSourceLocation().getWithinType();
            CrudRepository invokingRepository = (CrudRepository) appplicationContext.getBean(aClass);
            Optional byId = invokingRepository.findById(updatedEntity.getId());
            log.info("old value was " + byId.orElse(""));
        } catch (Throwable t) {

        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appplicationContext = applicationContext;
    }
}