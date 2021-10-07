package eCommerceWeek5.business.abstracts;

public interface MailVerificationService {
	
	void sendToVerifyMail(String mail);

	void verifyMail(String mail);
	
	boolean isVerified(String mail);

}
