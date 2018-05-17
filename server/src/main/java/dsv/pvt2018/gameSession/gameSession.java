package dsv.pvt2018.gameSession;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//får se om vi hinner göra en sådan här klass, väntar med det så länge.

@Entity
@Table(name = "gameSessions")
public class gameSession {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//minutes
	private int gameDuration; 
	
	
	
	
}
