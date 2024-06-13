package uni.isw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.isw.model.JefeDelArea;

@Repository
public interface JefeDelAreaRepository extends JpaRepository<JefeDelArea, Long> {
}
