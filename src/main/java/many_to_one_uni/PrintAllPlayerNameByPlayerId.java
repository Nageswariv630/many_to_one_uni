package many_to_one_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PrintAllPlayerNameByPlayerId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et=em.getTransaction();
		System.out.println("Enter Player Id:");
		int pid=sc.nextInt();
		List<Player>pl=em.createQuery("from Player").getResultList();
		for(Player p:pl) {
			if(p.getTeam().getId()==pid) {
				System.out.println(p.getName());
			}
		}
	}

}
