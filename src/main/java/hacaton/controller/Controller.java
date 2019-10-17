package hacaton.controller;

import hacaton.dao.Repository;
import hacaton.dto.EntityClass;
import hacaton.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventCalendar")
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping
    public ResponseEntity<List<EntityClass>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody EntityClass product) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityClass> findById(@PathVariable Long id) {
        Optional<EntityClass> entityClass = service.findById(id);
        if (!entityClass.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(entityClass.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityClass> update(@PathVariable Long id, @Valid @RequestBody EntityClass entityClass) {
        if (!service.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.save(entityClass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
