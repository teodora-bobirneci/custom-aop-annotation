package learn.aop.model;

import lombok.Getter;

@Getter
public abstract class BaseEntity {
    private final Integer id;

    public BaseEntity(Integer id) {
        this.id = id;
    }
}
