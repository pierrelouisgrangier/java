package fr.keyce.openit;

import java.util.Scanner;

import fr.keyce.Person;

public class HelloWorld {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			switchDay(args[i]);
		}
		int i = 0;
		while (i != args.length) {
			switchDay(args[i]);
			i = i + 1;
		}
		i = 0;
		do {
			switchDay(args[i]);
			i = i + 1;
		} while (i != args.length);

		Person person = new Person(args[0], Integer.valueOf(args[1]));
		person.incrementAge();
		System.out.println(person);
		person.incrementAge();
		person.incrementAge();
		
		System.out.println(person);
		String str;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("********** MON MENU **********");
				System.out.println("1 - Pour afficher la Personne");
				System.out.println("2 - Pour changer le nom");
				System.out.println("3 - Pour ajouter un an");
				System.out.println("0 - Pour quitter l'application");
				System.out.println("Veuillez saisir votre choix : ");
				str = sc.nextLine();
				switch (str) {
				case "1": 
					System.out.println(person);
					break;
				case "2":
					System.out.println("Veuillez saisir le nom :");
					str = sc.nextLine();
					person.setName(str);
					break;
				case "3":
					person.incrementAge();
					System.out.println("L'age a été incrémenté");
					break;
				default:
					break;
					
				}
			} while (!"0".equals(str));
			sc.close();
		}
		System.out.println("Aurevoir");
		

		
		//System.out.println("Resultat : " +calcul);
	}

	private static void switchDay(String day) {
		switch (day.toLowerCase()) {
		case "monday":
			System.out.println("Lundi");
			break;
		case "tuesday":
			System.out.println("Mardi");
			break;
		case "wednesday":
			System.out.println("Mercredi");
			break;
		default:
			System.out.println("Jour inconnu");
			break;
		}
	}

}
