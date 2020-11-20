package com.cg.healthassist.util;
import java.util.*;

import org.apache.log4j.Logger;

import com.cg.healthassist.App;
import com.cg.healthassist.exception.AuthenticationException;
import com.cg.healthassist.exception.InvalidException;

/**
 * A class to provide login utilities like sign in and sign up to patients.
 * @author Aman Soni
 *
 */
public class LoginUtil {
	/**
	 * Creating a logger.
	 */
	private static Logger logger=Logger.getLogger(App.class);
	/**
	 * Provides sign in and sign up functionality to patient based on their choice.
	 * @throws InvalidException
	 * @throws AuthenticationException
	 */
	public void loginUtil() throws InvalidException,AuthenticationException{
		Scanner sc = new Scanner(System.in);
		/**
		 * Welcoming patients in lifeline application.
		 */
		System.out.println("Welcome to Life Line Application");
		/**
		 * Showing the sign in sign up choice.
		 */
		System.out.println("1.Sign Up\n2.Sign in");
		System.out.println("Please enter your choice");
		String choice = sc.nextLine();
		/**
		 * Authenticate the user name whether it's unique or not.
		 */
		AuthenticationUtil verify = new AuthenticationUtil();\
		/**
		 * Show sign up page to patients.
		 */
		if(choice.equalsIgnoreCase("Sign up"))
		{
			/**
			 * Taking the details from the patient.
			 */
			System.out.println("Enter your name : ");
			String name = sc.nextLine();
			System.out.println("Enter your age : ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your phone number : ");
			long phoneNumber = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter your address : ");
			String address = sc.nextLine();
			/**
			 * Authenticatinig the details provided by the patient.
			 */
			boolean verificationProcess=false;
			while(verificationProcess==false) {
				try{
					System.out.println("Enter unique username : ");
					String userName = sc.nextLine();
					System.out.println("Enter password : ");
					String password = sc.nextLine();
					/**
					 * Throwing appropriate exception if any detail is wrong.
					 */
					if(userName.isBlank() && password.isBlank()) {
						throw new InvalidException("userName and password should not be empty");
					}
					else if(userName.isBlank()) {
						throw new InvalidException("userName should not be empty");
					}
					else if(password.isBlank()) {
						throw new InvalidException("Password should not be empty");
					}
					verificationProcess=verify.authenticateUserName(userName);
					if(!verificationProcess)
						throw new AuthenticationException("Username should be unique");
				}
				/**
				 * Handling the invalid input.
				 */
				catch(InvalidException e) {
					logger.info(e.getMessage());
				}
				/**
				 * Handling the authentication failure.
				 */
				catch(AuthenticationException a) {
					logger.info(a.getMessage());
				}
				
			}
		}
		/**
		 * Show sign in page to patients.
		 */
		else {
			/**
			 * Taking patient user name and password for sign in into lifeline application.
			 */
			boolean loginValidation = false;
			System.out.println("Enter the username : ");
			String username = sc.nextLine();
			System.out.println("Enter the password : ");
			String password = sc.nextLine();
			/**
			 * Validating if the user name and password is correct.
			 */
			loginValidation = verify.signInValidationOfUserNameAndPassword(username, password);
		}
	}
}
