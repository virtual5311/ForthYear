package tabele;

import java.sql.Timestamp;

public class Notificare {
	private int id;
	private Timestamp data;
	private String titlu;
	private String mesaj;
	
	public Notificare(int id, Timestamp data, String titlu, String mesaj) {
		this.id = id;
		this.data = data;
		this.titlu = titlu;
		this.mesaj = mesaj;
	}
	
	public int getId() {
		return id;
	}
	public Timestamp getData() {
		return data;
	}
	public String getTitlu() {
		return titlu;
	}
	public String getMesaj() {
		return mesaj;
	}
	
}
