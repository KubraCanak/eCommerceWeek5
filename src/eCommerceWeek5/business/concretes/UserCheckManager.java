package eCommerceWeek5.business.concretes;

import eCommerceWeek5.business.abstracts.UserCheckService;
import eCommerceWeek5.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserCheckManager implements UserCheckService {

	List<String> emails = new ArrayList<String>();

	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("isim alan� bo� b�rak�lamaz.l�tfen isminizi yaz�n�z!");
			return false;
		}

		else if (user.getFirstName().length() < 2) {
			System.out.println("isim en az iki harften olu�mal�d�r.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().isEmpty()) {

			System.out.println("Soyisim alan� bo� b�rak�lamaz.l�tfen soyisminizi yaz�n�z!");
			return false;
		} else if (user.getLastName().length() < 2) {
			System.out.println("soyisim en az 2 harften olu�mal�d�r.");
			return false;
		}

		return true;
	}

	@Override
	public boolean checkEmail(User user) {
		String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		// "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(user.getEmail()).find() == false) {
			System.out.println("email format�n�z ornek@ornek.com �eklinde olmal�");
			return false;
		} else if (user.getEmail().isEmpty()) {
			System.out.println("l�tfen mail adresinizi yaz�n�z");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().isEmpty()) {
			System.out.println("l�tfen parola belirleyiniz!");
			return false;
		} else if (user.getPassword().length() < 6) {
			System.out.println("parola en az 6 haneli olmal�d�r!");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkMailIsUnique(User user) {
		for (String string : emails) {
			if (string.contains(user.getEmail())) {
				System.out.println("bu email sisteme kay�tl�.l�tfen ba�ka bir mail kullan�n�z");
				return false;
			}

		}
		emails.add(user.getEmail());
		return true;

	}

	@Override
	public boolean checkValidate(User user) {

		if (checkFirstName(user) && checkLastName(user) && checkMailIsUnique(user) && checkPassword(user)
				&& checkEmail(user)) {
			return true;

		}

		return false;
	}

}
