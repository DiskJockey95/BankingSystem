package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Account;
import model.CreditCard;
import model.TypeAccount;

public class AccountDao {

	public ArrayList<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<Account>();
		Statement statement = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "trainee1",
					"QAZSE4");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Account");

			while (rs.next()) {
				if (rs.getString(5).equals("TFSA"))
					accounts.add(new Account(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), TypeAccount.TFSA));
				if (rs.getString(5).equals("Saving"))
					accounts.add(new Account(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), TypeAccount.Saving));
				if (rs.getString(5).equals("Chequing"))
					accounts.add(new Account(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), TypeAccount.Chequing));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}

	public Account getAccount(int choice) {
		Statement statement = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "trainee1",
					"QAZSE4");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Account WHERE account_id = " + choice);

			while (rs.next()) {
				if (rs.getString(5).equals("TFSA"))
					return new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), TypeAccount.TFSA);
				if (rs.getString(5).equals("Saving"))
					return new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4),
							TypeAccount.Saving);
				if (rs.getString(5).equals("Chequing"))
					return new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4),
							TypeAccount.Chequing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateTable(Account acc1, Account acc2) {
		Statement statement = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "trainee1",
					"QAZSE4");
			statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE Account SET amount = " + acc1.getAmount() + "WHERE account_id = " + acc1.getAccountId());
			statement.executeUpdate(
					"UPDATE Account SET amount = " + acc2.getAmount() + "WHERE account_id = " + acc2.getAccountId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTable(Account acc1, CreditCard cc2) {
		Statement statement = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "trainee1",
					"QAZSE4");
			statement = connection.createStatement();
			statement.executeUpdate(
					"UPDATE Account SET amount = " + acc1.getAmount() + "WHERE account_id = " + acc1.getAccountId());
			statement.executeUpdate(
					"UPDATE CreditCard SET current_balance = " + cc2.getCurrentBalance() + "WHERE account_id = " + cc2.getCreditCardId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
