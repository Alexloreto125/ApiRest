package AlexSpring.ApiRest.repositories;

import AlexSpring.ApiRest.entities.AutoreBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreDao extends JpaRepository<AutoreBlog, Integer> {
}
