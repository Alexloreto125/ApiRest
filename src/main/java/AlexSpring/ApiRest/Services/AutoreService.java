package AlexSpring.ApiRest.Services;

import AlexSpring.ApiRest.entities.AutoreBlog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service

public class AutoreService {

    private List<AutoreBlog> autoreBlogs= new ArrayList<>();


    //! RITORNIAMO TUTTI I BLOG
    public List<AutoreBlog> getAllAutori(){
        return this.autoreBlogs;

    }

    //! SALVIAMO UN BLOG
    public AutoreBlog saveBlog(AutoreBlog autoreBlog){
        Random rndm= new Random();
        autoreBlog.setId(rndm.nextInt(10,35));
        this.autoreBlogs.add(autoreBlog);
        return autoreBlog;

    }

    public  AutoreBlog findById(int id){
        AutoreBlog found = null;

        for (AutoreBlog autoreBlog:autoreBlogs){
            if (autoreBlog.getId()==id) found= autoreBlog;

        }
        if (found==null) throw new NotFoundException (id);
        return found;
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
        Iterator<AutoreBlog> iterator= this.autoreBlogs.iterator();

        while (iterator.hasNext()){
            AutoreBlog autoreBlog = iterator.next();
            if (autoreBlog.getId()== id){
                iterator.remove();
            }
        }
    }

}
