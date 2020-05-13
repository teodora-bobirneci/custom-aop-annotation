package learn.aop.model;

import lombok.Getter;

@Getter
public class DemoEntity extends BaseEntity {

    private String description;

    public DemoEntity(int id, String description) {
        super(id);
        this.description = description;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "description='" + description + '\'' +
                '}';
    }
}
