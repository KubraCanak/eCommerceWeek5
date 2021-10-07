package eCommerceWeek5.dataAccess.concretes;

import java.util.List;

import eCommerceWeek5.dataAccess.abstracts.UserDao;
import eCommerceWeek5.entities.concretes.User;
import java.util.ArrayList;

public class HibernateUserDao implements UserDao {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " hibernate ile eklendi");

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getEmailAndPassword(String email, String Password) {
		for (User user : users) {
			if ((user.getEmail() == email) && (user.getPassword() == Password)) {
				return true;

			}

		}
		return false;
	}

	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
