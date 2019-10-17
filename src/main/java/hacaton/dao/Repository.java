package hacaton.dao;

import hacaton.dto.EntityClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<EntityClass, Long> {
}
