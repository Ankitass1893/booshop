package coding.community.controllers.repository;

import coding.community.controllers.entity.Bread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreadRepository extends JpaRepository<Bread, Long> {

}
