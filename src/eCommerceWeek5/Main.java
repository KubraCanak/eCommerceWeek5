package eCommerceWeek5;

import eCommerceWeek5.business.concretes.MailVerificationManager;
import eCommerceWeek5.business.concretes.UserCheckManager;
import eCommerceWeek5.business.concretes.UserManager;
import eCommerceWeek5.core.GoogleLoginAdapter;
import eCommerceWeek5.dataAccess.concretes.HibernateUserDao;
import eCommerceWeek5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(1, "kübra", "çanak", "ornek@ornek.com", "000000");
		User user2 = new User(2, "kübra", "çanak", "ornek@ornek.com", "000000");
		User user3 = new User(3, "aaa", "bbb", "ornek@orn.com", "123456");
		User user5 = new User(5,"xxx","yyy","ays","545456");
//		LoginService loginService=new GoogleLoginAdapter();
//		loginService.login(user1);//test baþarýlý
//		UserCheckService checkService = new UserCheckManager();
//		checkService.checkEmail(user1);//test baþarýlý 
//		UserCheckService checkService= new UserCheckManager();
//		checkService.checkMailIsUnique(user1);//test baþarýlý
//		checkService.checkMailIsUnique(user2);//test baþarýlý
//		MailVerificationManager manager= new MailVerificationManager();
//		manager.sendToVerifyMail(user1.getEmail());
//		manager.verifyMail(user1.getEmail());
//		manager.isVerified(user1.getEmail());//true
		UserManager userManager = new UserManager(new UserCheckManager(), new HibernateUserDao(),
				new MailVerificationManager(), new GoogleLoginAdapter());
		userManager.signUp(user1);
		System.out.println(" ");
		userManager.signIn(user1);
		
		System.out.println("                                                   ");
		System.out.println("***************************************************");
		
		userManager.signIn(user3);//üye olmadan giriþ saðlanýyor mu? test amaçlý.
		
		System.out.println("                                                   ");
		System.out.println("---------------------------------------------------");
		
		userManager.signUp(user2);//ayný mail ile sisteme kayýt yapýlýyor mu? test amaçlý.
		userManager.signIn(user2);//giriþ saðlanýyor mu? test amaçlý.
		
		System.out.println("                                                   ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		userManager.signUp(user5);//kullanýcý bilgileri formata uygun deðilse ? test amaçlý.
		userManager.signIn(user5);
		

	}

}
