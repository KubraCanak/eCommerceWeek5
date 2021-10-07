package eCommerceWeek5.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceWeek5.business.abstracts.MailVerificationService;

public class MailVerificationManager implements MailVerificationService {

	List<String> validEmails = new ArrayList<String>();

	@Override
	public void sendToVerifyMail(String mail) {

		validEmails.add(mail);
		System.out.println(mail + " adresine do�rulama maili g�nderildi.");

	}

	@Override
	public void verifyMail(String mail) {

		if (validEmails.contains(mail)) {

			System.out.println("mail do�rulama ba�ar�l�.");
		}

	}

	@Override
	public boolean isVerified(String mail) {
		
		
		if (validEmails.contains(mail)) {
			
			return true;
			
		}
		return false;
	}

}
