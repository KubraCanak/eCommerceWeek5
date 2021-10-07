package eCommerceWeek5.business.abstracts;

import eCommerceWeek5.entities.concretes.User;

public interface UserService {

	void signUp(User user);
	void signIn(User user);
	
	
}
