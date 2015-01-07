package tabele;

import java.sql.Timestamp;
import java.util.StringTokenizer;

public class Notificare {
	private int id;
	private Timestamp data;
	private String titlu;
	private String mesaj;
	private NotificationType type = NotificationType.INFO;
	
	public Notificare(String toParse) {
		StringTokenizer tokenizer = new StringTokenizer(toParse);
		
		id   = Integer.parseInt(tokenizer.nextToken());
		data = Timestamp.valueOf(tokenizer.nextToken());
		titlu = tokenizer.nextToken();
		mesaj = tokenizer.nextToken();
		type = NotificationType.valueOf(tokenizer.nextToken());
		
		if (titlu.isEmpty() || mesaj.isEmpty() || titlu.length() > 20 || mesaj.length() > 180) {
			throw new IllegalArgumentException ("length(titlu) <= 20 and length(mesaj) <= 180");
		}
		
	}
	
	public Notificare(int id, Timestamp data, String titlu, String mesaj, NotificationType type) {
		this.id = id;
		this.data = data;
		this.titlu = titlu;
		this.mesaj = mesaj;
		this.type  = type;
	
		if (titlu.isEmpty() || mesaj.isEmpty() || titlu.length() > 20 || mesaj.length() > 180) {
			throw new IllegalArgumentException ("length(titlu) <= 20 and length(mesaj) <= 180");
		}
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
	
	public NotificationType getNotificationType() {
		return type;
		
	}
	
}
