package eCommerceWeek5.business.concretes;

import eCommerceWeek5.business.abstracts.MailVerificationService;
import eCommerceWeek5.business.abstracts.UserCheckService;
import eCommerceWeek5.business.abstracts.UserService;
import eCommerceWeek5.core.LoginService;
import eCommerceWeek5.dataAccess.abstracts.UserDao;
import eCommerceWeek5.entities.concretes.User;

public class UserManager implements UserService {

	boolean flag;

	UserCheckService checkService;
	UserDao userDao;
	MailVerificationService mailVerificationService;
	LoginService loginService;

	public UserManager(UserCheckService checkService, UserDao userDao, MailVerificationService mailVerificationService,
			LoginService loginService) {
		super();
		this.checkService = checkService;
		this.userDao = userDao;
		this.mailVerificationService = mailVerificationService;
		this.loginService = loginService;
	}

	@Override
	public void signUp(User user) {

		if (checkService.checkValidate(user)) {
			userDao.add(user);
			mailVerificationService.sendToVerifyMail(user.getEmail());
			

			System.out.println(user.getFirstName() + " " + user.getLastName() + ", sisteme �yelik sa�lad�");
			flag = true;
		} else {

			flag = false;
			System.out.println("l�tfen bilgilerinizi kontrol ederek �ye olmay� tekrar deneyiniz");
		}

	}

	@Override
	public void signIn(User user) {
		mailVerificationService.verifyMail(user.getEmail());

		if (flag && userDao.getEmailAndPassword(user.getEmail(), user.getPassword())
				&& mailVerificationService.isVerified(user.getEmail())) {
			loginService.login(user);
			System.out.println(user.getFirstName()+" "+user.getLastName()+", �ye giri�i sa�land�");
		} else if (flag && userDao.getEmailAndPassword(user.getEmail(), user.getPassword())) {
			System.out.println("l�tfen mailinizi do�rulay�n"+" "+user.getFirstName());

		} else {
			System.out.println("l�tfen �ye olunuz.");
		}

	}

}
