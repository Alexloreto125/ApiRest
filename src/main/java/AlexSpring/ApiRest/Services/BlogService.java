package AlexSpring.ApiRest.Services;

import AlexSpring.ApiRest.entities.AutoreBlog;
import AlexSpring.ApiRest.entities.BlogPost;
import AlexSpring.ApiRest.repositories.AutoreDao;
import AlexSpring.ApiRest.repositories.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    @Autowired
    private AutoreDao autoreDao;
    @Autowired
    private BlogDao blogDao;


    private List<BlogPost> blogPostList = new ArrayList<>();


    //! RITORNIAMO TUTTI I BLOG
    public List<BlogPost> getAllBlog() {
        return this.blogDao.findAll();

    }

    //! SALVIAMO UN BLOG
    public BlogPost saveBlog(BlogPost blogPost) {
        if (blogPost.getAutore() == null) {
            throw new NotAutoreException();
        }
        Random rndm = new Random();
        blogPost.setTempoLettura(rndm.nextInt(10, 35));
        return this.blogDao.save(blogPost);
    }

    public BlogPost findById(int id) {
        return this.blogDao.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    //TODO IL BODY
    public BlogPost updateBlog(int id, BlogPost updateBlog) {

        BlogPost found = null;

        for (BlogPost blog : blogPostList) {
            if (blog.getId() == id) found = blog;
            found.setContenuto(updateBlog.getContenuto());
            found.setCategoria(updateBlog.getCategoria());
            found.setCover(updateBlog.getCover());
            found.setTitolo(updateBlog.getTitolo());
            found.setTempoLettura(updateBlog.getTempoLettura());
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void delete(int id) {
         BlogPost blogPost= findById(id);
          this.blogDao.delete(blogPost);

    }
}
