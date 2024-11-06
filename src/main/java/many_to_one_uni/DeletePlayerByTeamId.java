package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeletePlayerByTeamId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		System.out.println("Enter Team Id:");
		int tid=sc.nextInt();
		Team t=em.find(Team.class, tid);
		if(t==null) {
			System.out.println("Invalid Team Id:");
		}
		Query q=em.createQuery("from Player");
		List<Player> pl=q.getResultList();
		for(Player p:pl) {
			if(p.getTeam().getId()==t.getId()) {
				et.begin();
				em.remove(pl);
				et.commit();
			}
		}
	}

}
