package eCommerceWeek5.dataAccess.abstracts;

import java.util.List;

import eCommerceWeek5.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void update(User user);
	void delete(User user);
	boolean getEmailAndPassword(String email,String Password);
	
	User get(int userId);
	List<User> getAll();
}
