package AlexSpring.ApiRest.Services;

import AlexSpring.ApiRest.entities.BlogPost;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {
    private List<BlogPost> blogPostList= new ArrayList<>();


        //! RITORNIAMO TUTTI I BLOG
    public List<BlogPost> getAllBlog(){
        return this.blogPostList;

    }

        //! SALVIAMO UN BLOG
    public BlogPost saveBlog(BlogPost blog){
        Random rndm= new Random();
        blog.setTempoLettura(rndm.nextInt(10,35));
        blog.setId(rndm.nextInt(10,35));
        this.blogPostList.add(blog);
        return blog;

    }

    public  BlogPost findById(int id){
        BlogPost found = null;

        for (BlogPost blog:blogPostList){
            if (blog.getId()==id) found= blog;

        }
        if (found==null) throw new NotFoundException (id);
        return found;
    }
        //TODO IL BODY
    public BlogPost updateBlog(int id, BlogPost updateBlog){

        BlogPost found = null;

        for (BlogPost blog:blogPostList){
            if (blog.getId()==id) found= blog;
            found.setContenuto(updateBlog.getContenuto());
            found.setCategoria(updateBlog.getCategoria());
            found.setCover(updateBlog.getCover());
            found.setTitolo(updateBlog.getTitolo());
            found.setTempoLettura(updateBlog.getTempoLettura());
        }
        if (found==null) throw new NotFoundException (id);
        return found;
    }

    public void delete(int id){
        Iterator<BlogPost> iterator= this.blogPostList.iterator();

        while (iterator.hasNext()){
            BlogPost blog = iterator.next();
            if (blog.getId()== id){
                iterator.remove();
            }
        }
    }
}
