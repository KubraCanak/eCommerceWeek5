package eCommerceWeek5.core;

import eCommerceWeek5.entities.concretes.User;
import eCommerceWeek5.google.GoogleLogin;

public class GoogleLoginAdapter implements LoginService{

	GoogleLogin googleLogin= new GoogleLogin();
	
	@Override
	public void login(User user) {
		
		googleLogin.loginViaGoogle(user.getFirstName());
		//message=user.getFirstName(google.GoogleLogin)
		
		
		
	}

}
