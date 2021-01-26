package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.TypeCard;
import model.CreditCard;

public class CreditCardDao {
	
	public ArrayList<CreditCard> getCreditCards() {
		ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
		Statement statement = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "trainee1",
					"QAZSE4");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM CreditCard");

			while (rs.next()) {
				if (rs.getString(7).equals("Cashback"))
					creditCards.add(new CreditCard(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), TypeCard.Cashback));
				if (rs.getString(7).equals("Points"))
					creditCards.add(new CreditCard(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), TypeCard.Points));
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
		return creditCards;
	}

	public CreditCard getCreditCard(int choice) {
		Statement statement = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "trainee1",
					"QAZSE4");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM CreditCard WHERE account_id = " + choice);

			while (rs.next()) {
				if (rs.getString(7).equals("Cashback"))
					return new CreditCard(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), TypeCard.Cashback);
				if (rs.getString(7).equals("Points"))
					return new CreditCard(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), TypeCard.Points);
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
	
	

}
