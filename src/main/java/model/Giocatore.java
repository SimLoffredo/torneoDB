package model;
import java.sql.Date;

public class Giocatore {

		// ATTRIBUTI 
		private int id;
		private String nome; 
		private String cognome;
		private int nMaglia;
		private Date dataNascita;
		private int id_squadra;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public int getnMaglia() {
			return nMaglia;
		}
		public void setnMaglia(int nMaglia) {
			this.nMaglia = nMaglia;
		}
		public Date getDataNascita() {
			return dataNascita;
		}
		public void setDataNascita(Date dataNascita) {
			this.dataNascita = dataNascita;
		}
		public int getId_squadra() {
			return id_squadra;
		}
		public void setId_squadra(int id_squadra) {
			this.id_squadra = id_squadra;
		}
		@Override
		public String toString() 
		{
			return "  " + id + "  " + nome + "  " + cognome + "  " + nMaglia + "  " + dataNascita + "  " + id_squadra; 
		}
		
		public Giocatore(){};
		
		public Giocatore(int id, String nome, String cognome, int nMaglia, Date dataNascita, int id_squadra) {
			
			this.id=id;
			this.nome=nome;
			this.cognome=cognome;
			this.nMaglia=nMaglia;
            this.dataNascita=dataNascita;
            this.id_squadra=id_squadra;
			
		}
		
}