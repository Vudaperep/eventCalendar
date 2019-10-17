package hacaton.service;

import hacaton.dao.Repository;
import hacaton.dto.EntityClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Service {

    private final Repository repository;

    public List<EntityClass> findAll() {
        return repository.findAll();
    }

    public Optional<EntityClass> findById(Long id) {
        return repository.findById(id);
    }

    public EntityClass save(EntityClass entityClass) {
        return repository.save(entityClass);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
