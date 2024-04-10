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

public class AutoreService {
    @Autowired
    private AutoreDao autoreDao;
    @Autowired
    private BlogDao blogDao;
    private List<AutoreBlog> autoreBlogs= new ArrayList<>();


    //! RITORNIAMO TUTTI I BLOG
    public List<AutoreBlog> getAllAutori(){
        return this.autoreDao.findAll();

    }

    //! SALVIAMO UN BLOG
    public AutoreBlog saveBlog(AutoreBlog autoreBlog){
        this.autoreBlogs.add(autoreBlog);
        return this.autoreDao.save(autoreBlog);
    }

    public  AutoreBlog findById(int id){
        return this.autoreDao.findById(id).orElseThrow(()-> new NotAutoreException());
    }
    //TODO IL BODY
    public AutoreBlog updateAutore(int id, AutoreBlog updateBlog){

        AutoreBlog found = null;

        for (AutoreBlog autoreBlog:autoreBlogs){
            if (autoreBlog.getId()==id) found= autoreBlog;
        }
        if (found==null) throw new NotFoundException (id);
        return found;
    }

    public void delete(int id){
        AutoreBlog autore= findById(id);
        if (autore==null) throw new NotAutoreException();
        List<BlogPost> blogList= autore.getBlogList();

        for (BlogPost blog : blogList) {
            blogDao.delete(blog);
        }

        this.autoreDao.delete(autore);

    }

}
