package eCommerceWeek5.business.abstracts;

import eCommerceWeek5.entities.concretes.User;

public interface UserCheckService {
	
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	boolean checkPassword(User user);
	boolean checkMailIsUnique(User user);
	boolean checkValidate(User user);

}
