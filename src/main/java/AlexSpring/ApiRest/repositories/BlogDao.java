package AlexSpring.ApiRest.repositories;

import AlexSpring.ApiRest.entities.AutoreBlog;
import AlexSpring.ApiRest.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<BlogPost, Integer> {
}
