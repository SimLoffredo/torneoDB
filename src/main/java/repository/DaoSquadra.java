package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utility.Connettore;
import model.Squadra;

public class DaoSquadra  {
private static DaoSquadra instance = null;    // Unica instanza della classe 
	
	public static DaoSquadra get_instance() {
		if(instance == null)
			instance = new DaoSquadra();
		return instance; 
	}
	
	private DaoSquadra() {
		
	}

	public void addSquadra(String nome) {
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		String sql = "Insert into squadre(nome) values(?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
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

	public void modificaSquadra(String nome,int idSquadra) {
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		String sql = "update squadre set nome = ? where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, idSquadra);
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
	
	public Squadra getSquadra(int id) {
		Squadra squadra = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  
		Connettore c = Connettore.get_instance(); 
		Connection conn = c.apri_connessione(); 
		String sql = "SELECT * from squadre where id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery(); 
			while(rs.next()) 
			{
				squadra = new Squadra();
				squadra.setId(rs.getInt("id"));
				squadra.setNome(rs.getString("nome"));
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
		return squadra;
	}

	public List<Squadra> getSquadre() {
		List<Squadra> gruppi = new ArrayList<Squadra>();
		Squadra squadra = null;
		PreparedStatement ps = null;
		ResultSet rs = null;  
		Connettore c = Connettore.get_instance(); 
		Connection conn = c.apri_connessione();  
		String sql = "SELECT * from squadre";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next())
			{
				squadra = new Squadra();
				squadra.setId(rs.getInt("id"));
				squadra.setNome(rs.getNString("nome"));
				gruppi.add(squadra);
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
		return gruppi;
	}

	public void eliminaSquadra(int id) {
		Connettore c = Connettore.get_instance();
		Connection conn = c.apri_connessione();
		PreparedStatement ps = null;
		String sql = "delete from squadre where id = ?";
		try {
			ps = conn.prepareStatement(sql);
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
