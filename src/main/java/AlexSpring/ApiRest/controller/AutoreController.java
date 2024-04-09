package AlexSpring.ApiRest.controller;

import AlexSpring.ApiRest.Services.AutoreService;
import AlexSpring.ApiRest.Services.BlogService;
import AlexSpring.ApiRest.entities.AutoreBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    private AutoreService autore;

    //* 5 ENDPOINT


    //!GET
    @GetMapping
    private List<AutoreBlog> getAllAutori() {
        return this.autore.getAllAutori();

    }

    @GetMapping("/{autoreId}")
    private AutoreBlog getById(@PathVariable int autoreId) {
        return this.autore.findById(autoreId);
    }

    //! POST

    @PostMapping
    private AutoreBlog newBlog( @RequestBody AutoreBlog autorePost){
        return this.autore.saveBlog(autorePost);

    }

    //! PATCH

    //    @PatchMapping("/{autoreId}")
//    private AutoreBlog updateBlog(@PathVariable int autoreId, @RequestBody AutoreBlog autorePost){
//    return this.autore.updateBlog(autoreId,autorePost);
//
//    }
    @PutMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.CREATED)
    private AutoreBlog updateAutorePut(@PathVariable int autoreId, @RequestBody AutoreBlog autorePost){
        return this.autore.updateAutore(autoreId,autorePost);

    }

    //! DELETE

    @DeleteMapping("/{autoreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void  deleteBlog(@PathVariable int autoreId){
        this.autore.delete(autoreId);
    }
}
