package me.maduranga;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maduranga.Blogger;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({"/users"})
public class UserController {

	private List<Blogger> bloggers = createList();
	
	@GetMapping(produces = "application/json")
	public List<Blogger> firstPage() {
		return bloggers;
	}
	
/*	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {
		return new User("User successfully authenticated");
	}
	*/
	@DeleteMapping(path = { "/{id}" })
	public Blogger delete(@PathVariable("id") int id) {
		Blogger deletedblg = null;
		for (Blogger blg : bloggers) {
			//if (blg.getUserId().equals(id)) {
			if (blg.getUserId() == id) {
				bloggers.remove(blg);
				deletedblg = blg;
				break;
			}
		}
		return deletedblg;
	}

	@PostMapping
	public Blogger create(@RequestBody Blogger user) {
		bloggers.add(user);
		return user;
	}
	
	private static List<Blogger> createList() {
		List<Blogger> tempBloggers = new ArrayList<>();
		Blogger user1 = new Blogger();
		user1.setUserId(1);
		user1.setEmail("userone@gmail.com");
		user1.setPassword("pwd");

		Blogger user2 = new Blogger();
		user2.setUserId(2);
		user2.setEmail("usertwo@gmail.com");
		user2.setPassword("password");
		
		tempBloggers.add(user1);
		tempBloggers.add(user2);
		
		return tempBloggers;
	}
	
}
