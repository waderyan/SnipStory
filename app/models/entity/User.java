package models.entity;

import java.util.Date;
import java.util.Calendar;
import common.util.StringUtils;

/** 
 * This <code> class </code> represents a User object. 
 * @author wadeanderson
 */
public class User {

	// Fields

	private String _username;
	private String _email;
	private String _password;
	private Date _birthdate;

	// Constructor

	/**
	 * Checks if the given params are valid.
	 * @return true if valid, false otherwise
	 */
	private static boolean isValidParams (String username, String email, String password, Date birthdate) {
		return !StringUtils.isEmptyOrNull(username, email, password) 
			&&  isValidBirthdate (birthdate);
	}

	/**
	 * Checks if the birthdate is valid.
	 * @param  birthdate
	 * @return true if valid, false otherwise
	 */
	private static boolean isValidBirthdate (Date birthdate) {
		return birthdate != null;
	}

	/**
	 * Returns a new User object.
	 * @param  username
	 * @param  email
	 * @param  password
	 * @param  birthdate
	 * @return
	 */
	public User (String username, String email, String password, Date birthdate) {
		if(!isValidParams(username, email, password, birthdate)) {
			throw new IllegalArgumentException ("invalid arguments for User constructor");
		}

		_username = username;
		_email = email;
		_password = password;
		_birthdate = birthdate;
	}

	// Getters and Setters

	public String getUsername () {
		assert (true);
		return _username;
	}

	public void setUsername (String username) {
		if (StringUtils.isEmptyOrNull(username)) {
			throw new IllegalArgumentException ("username cannot be empty or null");
		}
		_username = username;
	}

	public String getEmail () {
		assert (true);
		return _email;
	}

	public void setEmail (String email) {
		if (StringUtils.isEmptyOrNull(email)) {
			throw new IllegalArgumentException ("email cannot be empty or null");
		}
		_email = email;
	}

	public String getPassword () {
		assert (true);
		return _password;
	}

	public void setPassword (String password) {
		if (StringUtils.isEmptyOrNull(password)) {
			throw new IllegalArgumentException ("password cannot be empty or null");
		}
		_password = password;
	}

	public Date getBirthdate () {
		assert (true);
		return _birthdate;
	}

	public void setBirthdate (Date birthdate) {
		if (isValidBirthdate(birthdate)) {
			throw new IllegalArgumentException ("birthdate is invalid");
		}
		_birthdate = birthdate;
	}
}






















