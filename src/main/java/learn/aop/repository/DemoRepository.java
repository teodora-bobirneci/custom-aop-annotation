package learn.aop.repository;

import learn.aop.model.DemoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DemoRepository implements CrudRepository<DemoEntity, Integer> {

    public DemoEntity save(DemoEntity demoEntity){
        return demoEntity;
    }


    @Override
    public Optional<DemoEntity> findById(Integer integer) {
        return Optional.of(new DemoEntity(1, "old description"));
    }

    @Override
    public <S extends DemoEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<DemoEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<DemoEntity> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(DemoEntity demoEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends DemoEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
