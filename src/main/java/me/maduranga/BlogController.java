package me.maduranga;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import com.maduranga.Blog;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/blog"})
public class BlogController {
	
	
	@Autowired
    BlogRespository blogRespository;

	//@CrossOrigin(origins = "http://localhost:4200")
	
	@GetMapping(produces = "application/json")
    public List<Blog> index(){
        return blogRespository.findAll();
    }

    @GetMapping("/{id}")
    public Blog show(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        return blogRespository.findOne(blogId);
    }

    @PostMapping("/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping
    public Blog create(@RequestBody Map<String, String> body){
    	int uId = Integer.parseInt( body.get("userid"));
    	int userid = uId;
        String title = body.get("title");
        String content = body.get("content");
        return blogRespository.save(new Blog(userid, title, content));
    }

    @PutMapping("/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
        int blogId = Integer.parseInt(id);
        // getting blog
        Blog blog = blogRespository.findOne(blogId);
        blog.setTitle(body.get("title"));
        blog.setContent(body.get("content"));
        return blogRespository.save(blog);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        int blogId = Integer.parseInt(id);
        blogRespository.delete(blogId);
        return true;
    }
//	BlogMockedData blogMockedData = BlogMockedData.getInstance();

//  @GetMapping("/blog")
//  public List<Blog> index(){
//      return blogMockedData.fetchBlogs();
//  }
//
//  @GetMapping("/blog/{id}")
//  public Blog show(@PathVariable String id){
//      int blogId = Integer.parseInt(id);
//      return blogMockedData.getBlogById(blogId);
//  }
//
//  @PostMapping("/blog/search")
//  public List<Blog> search(@RequestBody Map<String, String> body){
//      String searchTerm = body.get("text");
//      return blogMockedData.searchBlogs(searchTerm);
//  }
//
//  @PostMapping("/blog")
//  public Blog create(@RequestBody Map<String, String> body){
//      int id = Integer.parseInt(body.get("id"));
//      String title = body.get("title");
//      String content = body.get("content");
//      return blogMockedData.createBlog(id, title, content);
//  }
//
//  @PutMapping("/blog/{id}")
//  public Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
//      int blogId = Integer.parseInt(id);
//      String title = body.get("title");
//      String content = body.get("content");
//      return blogMockedData.updateBlog(blogId, title, content);
//  }
//
//  @DeleteMapping("blog/{id}")
//  public boolean delete(@PathVariable String id){
//      int blogId = Integer.parseInt(id);
//      return blogMockedData.delete(blogId);
//  }
//	  

}
