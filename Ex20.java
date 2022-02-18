package ex20;

import java.util.Scanner;

public class Ex20 {

//	Es 20. 
//	Scrivere un programma che per una classe con 10 alunni per ogni alunno:
//	– chiede quanti voti ha,
//	– li fa inserire
//	– ne calcola per ogni alunno la media
//	– dice quante insufficienze ha quell’alunno.
//	Dopo che sono stati inseriti i voti per tutti gli alunni, il programma 
//	dice quanti voti insufficienti in tutto ci sono stati e quanti alunni hanno una media inferiore al 6.

	private int[] students = new int[3];	// changed to 3 student.. 10 are too many xD
	private int nrVotes, insufficientCounterVotes;
	private double[] votes;
	private Scanner sc = new Scanner(System.in);
	
	// get nrVotes
	public int getNrVotes() {
		return nrVotes;
	}
	
	// set nrVotes
	public void setNrVotes() {
		while(true) {
			System.out.print("HOW MANY VOTES DO U HAVE: ");
			int nrVotes = sc.nextInt();
			if (nrVotes > 0) {
				this.nrVotes = nrVotes;
				break;
			}
			else {
				System.out.print("\nWRONG..\nDIGIT AGAIN -> ");
			}
		}
	}
	
	// get votes[]
	public double[] getVotes() {
		return votes;
	}
	
	// set votes[]
	public void setVotes() {
		double votes[] = new double[getNrVotes()];
		for (int i = 0; i < votes.length; i++) {
			while(true) {
				System.out.print("DIGIT VOTE NR." + (i+1) + " : ");
				votes[i] = sc.nextInt();
				if (votes[i] > 0 && votes[i] <= 10)
					break;
			}
		}
		this.votes = votes;
	}
	
	// avg votes method
	public double avgVotes() {
		double sum = 0;
		for (int i = 0; i < votes.length; i++) {
			sum += votes[i];
		}
		
		double avg = (double) (sum / votes.length);
		
		return avg;
	}
	
	// get insufficient counter votes
	public int getInsuffientCounterVotes() {
		return insufficientCounterVotes;
	}
	
	// check how many insufficient votes method
	public void setInsuffientCounterVotes() {
		int insufficientCounterVotes = 0;
		
		for (int i = 0; i < getVotes().length; i++) {
			if (getVotes()[i] < 6)
				insufficientCounterVotes++;
		}
		
		this.insufficientCounterVotes = insufficientCounterVotes;
	}
	
	// every student have to select how many votes they have,
	// the vote..
	// and check how many insufficient votes are in this class
	// + how many stds have at least one < 6 vote..
	public void everyStudentCycle() {
		int nrInsufficients = 0;
		int counterStdWithInsufficients = 0;
		for (int i = 0; i < students.length; i++) {
			System.out.println("\n=====================================\n"
					+ "STUDENT NR." + (i+1) );
			setNrVotes();
			setVotes();
			System.out.print("\n> SO UR VOTES ARE: | ");
			for (double z : getVotes()) {
				System.out.print(z + " | ");
			}
			System.out.println("\n\nTHE AVG OF UR VOTES IS: " + avgVotes() );
			setInsuffientCounterVotes();
			System.out.print("THE NUMBER OF INSUFFICIENT VOTES U IS: " + getInsuffientCounterVotes() + "\n");
			
			nrInsufficients += getInsuffientCounterVotes();
			
			if (getInsuffientCounterVotes() > 0)
				counterStdWithInsufficients++;
			
		}
		System.out.println("\n============================\n"
				+ "\n> THE NUMBER OF INSUFFICIENT VOTES IS: " + nrInsufficients
				+ "\n\n> THE NR. OF STUDENTS,\nIN THIS CLASS\nWITH INSUFFICIENT VOTES ARE: " + counterStdWithInsufficients);
	}
	
}
