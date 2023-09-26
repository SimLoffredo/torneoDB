package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.Connettore;
import model.*;

public final class DaoGiocatore{
	
	private static DaoGiocatore instance = null;
	
	public static DaoGiocatore getInstance() {
		if(instance == null)
			instance = new DaoGiocatore();
		return instance;
	}
	
	private DaoGiocatore() {
		
	}
	

	// ########## METODI DAO: CRUD ##########
	
	public void addGiocatore(Giocatore g) // INSERIMENTO OGGETTO TAVOLO NEL DATABASE
	{
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("Insert into giocatori(nome, cognome, nMaglia, dataNascita, id_squadra) values(?, ?, ?, ?, ?)");
			ps.setString(1, g.getNome());
			ps.setString(2, g.getCognome());
			ps.setInt(3, g.getnMaglia());
			ps.setDate(4,g.getDataNascita());
			ps.setInt(5, g.getId_squadra());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	public Giocatore getGiocatore(int id) // RECUPERO L'ENTITA' TAVOLO, SELEZIONATA PER ID, DAL DATABASE 
	{
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Giocatore g = null;
		
		try {
			ps = conn.prepareStatement("Select * from giocatori where id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				g = new Giocatore();
				g.setId(rs.getInt("id"));
				g.setNome(rs.getString("nome"));
				g.setCognome(rs.getString("cognome"));
				g.setnMaglia(rs.getInt("nmaglia"));
				g.setDataNascita(rs.getDate("dataNascita"));
				g.setId_squadra(rs.getInt("id_squadra"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return g;
	}

	public List<Giocatore> getGiocatori() // RECUPERO UNA LISTA (RECORD) DI TAVOLI DAL DATABASE
	{
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Giocatore g = null;
		List<Giocatore> giocatori= new ArrayList<Giocatore>();
		
		try {
			ps = conn.prepareStatement("Select * from giocatori");
			rs = ps.executeQuery();
			while (rs.next()) {
				g = new Giocatore();
				g.setId(rs.getInt("id"));
				g.setNome(rs.getString("nome"));
				g.setCognome(rs.getString("cognome"));
				g.setnMaglia(rs.getInt("nMaglia"));
				g.setDataNascita(rs.getDate("dataNascita"));
				g.setId_squadra(rs.getInt("id_squadra"));
				giocatori.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return giocatori;
	}
	public List<Giocatore> getGiocatoribyID(int id) // RECUPERO UNA LISTA (RECORD) DI TAVOLI DAL DATABASE
	{
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Giocatore g = null;
		List<Giocatore> giocatori= new ArrayList<Giocatore>();
		
		try {
			ps = conn.prepareStatement("Select * from giocatori where id_squadra=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				g = new Giocatore();
				g.setId(rs.getInt("id"));
				g.setNome(rs.getString("nome"));
				g.setCognome(rs.getString("cognome"));
				g.setnMaglia(rs.getInt("nMaglia"));
				g.setDataNascita(rs.getDate("dataNascita"));
				g.setId_squadra(rs.getInt("id_squadra"));
				giocatori.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return giocatori;
	}

	public void updateGiocatore(Giocatore g)  // MODIFICA DEI CAMPI DI UN TAVOLO NEL DATABASE
	{
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
	
		try {
			ps = conn.prepareStatement("Update giocatori set nome = ?, cognome = ?, nMaglia = ?, dataNascita=?, id_squadra=? where id = ?");
			ps.setString(1, g.getNome());
			ps.setString(2, g.getCognome());
			ps.setInt(3, g.getnMaglia());
			ps.setDate(4,g.getDataNascita());
			ps.setInt(5, g.getId_squadra());
			ps.setInt(6, g.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void svincolaGiocatori(int id) {
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE giocatori SET id_squadra = 100 WHERE id_squadra = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateSvincolato (int idGiocatore, int idSquadra) {
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("UPDATE giocatori SET id_squadra = ? WHERE id = ?");
			ps.setInt(2, idGiocatore);
			ps.setInt(1,idSquadra);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteGiocatore(int id) // ELIMINAZIONE DI UN TAVOLO DAL DATABASE
	{
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("delete from giocatori where id = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}