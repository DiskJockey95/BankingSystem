package view;

import java.util.Scanner;

import controller.AccountDao;
import exception.InsufficientFundsException;
import model.Account;
import model.CreditCard;

public class MainApp {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String user = "admin";
		String pass = "admin";
		String choice = "";
		boolean logged = false;

		System.out.println("Welcome to online banking!");
		while (!choice.equalsIgnoreCase("q")) {
			if (!logged) {
				logged = login(user, pass);
				System.out.println("Successful logon");
			}
			System.out.println("Would you like to View (B)alance, (T)ranfer Funds, or (Q)uit?");
			choice = scanner.nextLine();
			if (choice.equalsIgnoreCase("b")) {
				System.out.println("View (C)redit Cards or (A)ccounts?");
				choice = scanner.nextLine();
				if (choice.equalsIgnoreCase("a")) {
					viewAccountBalance();
				} else if (choice.equalsIgnoreCase("c")) {
					viewCreditBalance();
				}
			} else if (choice.equalsIgnoreCase("t")) {
				System.out.println("Would you like to transfer from one account to another (A)ccount or one account to a (C)redit Card?");
				choice = scanner.nextLine();
				if (choice.equalsIgnoreCase("a")) {
					transferFundsAccount();
				} else if (choice.equalsIgnoreCase("c")) {
					transferFundsCreditCard();
				}
			}
		}

	}

	private static void transferFundsCreditCard() {
		AccountDao accDao = new AccountDao();
		CreditCardDao ccDao = new CreditCardDao();

		boolean verified = false;
		Account acc1 = null;
		CreditCard cc2 = null;
		int choice = 0;
		double amount = 0.0;

		while (!verified) {
			if (acc1 == null) {
				System.out.println("From which account would you like to transfer?");
				choice = scanner.nextInt();
				acc1 = accDao.getAccount(choice);
			}
			if (cc2 == null) {
				System.out.println("To which credit card would you like to transfer?");
				choice = scanner.nextInt();
				cc2 = ccDao.getCreditCard(choice);
			}
			System.out.println("How much would you like to transfer?");
			amount = scanner.nextDouble();
			if (acc1 != null && cc2 != null)
				if (acc1.getPersonId() == cc2.getPersonId())
					verified = true;
				else {
					acc1 = null;
					cc2 = null;
				}
			scanner.nextLine();
		}
		try {
			acc1.transferTo(cc2, amount);
			accDao.updateTable(acc1, cc2);
		} catch (InsufficientFundsException e) {
			System.out.println(e.toString());
		}
	}

	private static void transferFundsAccount() {
		AccountDao accDao = new AccountDao();

		boolean verified = false;
		Account acc1 = null;
		Account acc2 = null;
		int choice = 0;
		double amount = 0.0;

		while (!verified) {
			if (acc1 == null) {
				System.out.println("From which account would you like to transfer?");
				choice = scanner.nextInt();
				acc1 = accDao.getAccount(choice);
			}
			if (acc2 == null) {
				System.out.println("To which account would you like to transfer?");
				choice = scanner.nextInt();
				acc2 = accDao.getAccount(choice);
			}
			System.out.println("How much would you like to transfer?");
			amount = scanner.nextDouble();
			if (acc1 != null && acc2 != null)
				if (acc1.getPersonId() == acc2.getPersonId())
					verified = true;
				else {
					acc1 = acc2 = null;
				}
			scanner.nextLine();
		}
		try {
			acc1.transferTo(acc2, amount);
			accDao.updateTable(acc1, acc2);
		} catch (InsufficientFundsException e) {
			System.out.println(e.toString());
		}
	}
	
	private static void viewCreditBalance() {
		CreditCardDao ccDao = new CreditCardDao();
		for (CreditCard cc : ccDao.getCreditCards()) {
			System.out.println(cc);
		}
	}

	private static void viewAccountBalance() {
		AccountDao accDao = new AccountDao();
		for (Account acc : accDao.getAccounts()) {
			System.out.println(acc);
		}
	}

	private static boolean login(String u, String p) {
		boolean verified = false;
		String input = "";
		while (!verified) {
			System.out.println("Please enter your username");
			input = scanner.nextLine();
			if (!input.equalsIgnoreCase(u))
				continue;
			System.out.println("Please enter your password");
			input = scanner.nextLine();
			if (!input.equalsIgnoreCase(p))
				continue;
			verified = true;
		}
		return verified;
	}

}
