package AlexSpring.ApiRest.controller;

import AlexSpring.ApiRest.Services.AutoreService;
import AlexSpring.ApiRest.Services.BlogService;
import AlexSpring.ApiRest.entities.AutoreBlog;
import AlexSpring.ApiRest.entities.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blog;
    @Autowired
    private AutoreService autoreService;


    //* 5 ENDPOINT


    //!GET
    @GetMapping
    private List<BlogPost> getAllBlog() {
        return this.blog.getAllBlog();

    }

    @GetMapping("/{blogId}")
    private BlogPost getById(@PathVariable int blogId) {
        return this.blog.findById(blogId);
    }

    //! POST

    @PostMapping
    private BlogPost newBlog( @RequestBody BlogPost blogPost){
    return this.blog.saveBlog(blogPost);

    }

    //! PATCH

//    @PatchMapping("/{blogId}")
//    private BlogPost updateBlog(@PathVariable int blogId, @RequestBody BlogPost blogPost){
//    return this.blog.updateBlog(blogId,blogPost);
//
//    }
    @PutMapping("/{blogId}")
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost updateBlogPut(@PathVariable int blogId, @RequestBody BlogPost blogPost){
    return this.blog.updateBlog(blogId,blogPost);

    }

    //! DELETE

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void  deleteBlog(@PathVariable int blogId){
        this.blog.delete(blogId);
    }

}
