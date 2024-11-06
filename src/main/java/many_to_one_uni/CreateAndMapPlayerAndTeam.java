package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapPlayerAndTeam {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		Team t=new Team(0, "India", "Ghambir");
		Player p1=new Player(0, "Hardik_Pandya", 33, t);
		et.begin();
		em.persist(t);
		em.persist(p1);
		et.commit();
	}

}
