package many_to_one_uni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddPlayerToExistingTeam {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		System.out.println("Enter Team Id:");
		int tid=sc.nextInt();
		Team team=em.find(Team.class, tid);
		if(team==null) {
			System.err.println("Invalid Team Id:");
			return;
		}
		System.out.println("Enter Player Name:");
		String name=sc.next();
		System.out.println("Enter Jersey Number:");
		int jerseyNo=sc.nextInt();
		Player p=new Player(0, name, jerseyNo, team);
		et.begin();
		em.persist(p);
		et.commit();
		System.out.println("Done..");
	}

}
