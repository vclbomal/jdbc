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
		/* Exécution d'une requête d'écriture */
		//int resultat = st.executeUpdate( "INSERT INTO tb_bomal (id_utilisateur, message, date) VALUES (21031995, 'bonjour', NOW());" );
		
		PreparedStatement preparedStatement = cn.prepareStatement( "SELECT id, id_utilisateur, message, date  FROM tb_bomal;" );
		/* Exécution d'une requête de lecture */
		//ResultSet resultat = st.executeQuery( "SELECT id, id_utilisateur, message, date  FROM tb_bomal;" );
		ResultSet resultat = preparedStatement.executeQuery();
		/* Récupération des données du résultat de la requête de lecture */
		while ( resultat.next() ) {
		    int id = resultat.getInt( "id" );
		    int idUtilisateur = resultat.getInt( "id_utilisateur" );
		    String messageUtilisateur = resultat.getString( "message" );
		    Date dateUtilisateur = resultat.getDate( "date" );
		    
		    System.out.println("message de "+ idUtilisateur + " le "+ dateUtilisateur);
		}
		//rien
		//un autre
		resultat.close();
		cn.close();
		
				
	}

}
