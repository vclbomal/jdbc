package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName( "com.mysql.jdbc.Driver" );
		Connection cn= DriverManager.getConnection( "jdbc:mysql://localhost:3306/epf2017", "root", "");
		Statement st= cn.createStatement();
		/* Ex�cution d'une requ�te d'�criture */
		//int resultat = st.executeUpdate( "INSERT INTO tb_bomal (id_utilisateur, message, date) VALUES (21031995, 'bonjour', NOW());" );
		
		PreparedStatement preparedStatement = cn.prepareStatement( "SELECT id, id_utilisateur, message, date  FROM tb_bomal;" );
		/* Ex�cution d'une requ�te de lecture */
		//ResultSet resultat = st.executeQuery( "SELECT id, id_utilisateur, message, date  FROM tb_bomal;" );
		ResultSet resultat = preparedStatement.executeQuery();
		/* R�cup�ration des donn�es du r�sultat de la requ�te de lecture */
		while ( resultat.next() ) {
		    int id = resultat.getInt( "id" );
		    int idUtilisateur = resultat.getInt( "id_utilisateur" );
		    String messageUtilisateur = resultat.getString( "message" );
		    Date dateUtilisateur = resultat.getDate( "date" );
		    
		    System.out.println("message de "+ idUtilisateur + " le "+ dateUtilisateur);
		}
		resultat.close();
		cn.close();
			// une autre modification	
		//comment test dev
	}

}
