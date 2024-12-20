package fr.keyce;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import fr.keyce.openit.Computer;
import fr.keyce.openit.ComputersReaderWriter;
import fr.keyce.openit.DefaultComputer;
import fr.keyce.openit.MaterialInterface;
import fr.keyce.openit.apple.AppleComputer;
import fr.keyce.openit.ibm.IBMComputer;

public class Menu {

	private List<Computer> materials = new ArrayList<Computer>();
	private ComputersReaderWriter computersWriter = new ComputersReaderWriter();

	public void displayMenu() {
		final JFrame mainMenu = new JFrame("Menu principal");
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		materials = computersWriter.read();
		mainMenu.setSize(400,500);
		displayMainMenu(mainMenu);
		mainMenu.setVisible(true);
	}

	private void displayMainMenu(JFrame frame) {
		JPanel mainMenu = new JPanel();
		mainMenu.setLayout(new GridLayout(5, 1));
		JButton buttonAddComputer = new JButton("Ajouter un ordinateur");
		JButton buttonDelComputer = new JButton("Supprimer un ordinateur");
		JButton buttonUpdateComputer = new JButton("Modifier un ordinateur");
		JButton buttonShowComputer = new JButton("Afficher les ordinateurs");
		JButton buttonExit = new JButton("Quitter l'application");
		buttonAddComputer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenu);
				displayAddComputer(frame);
			}
		});
		buttonShowComputer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(mainMenu);
				displayComputers(frame);

			}
		});
		buttonExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainMenu.add(buttonAddComputer);
		mainMenu.add(buttonDelComputer);
		mainMenu.add(buttonUpdateComputer);
		mainMenu.add(buttonShowComputer);
		mainMenu.add(buttonExit);
		frame.add(mainMenu);
		frame.setVisible(false);
		frame.setVisible(true);
	}

	private void displayAddComputer(JFrame frame) {
		/* Add Computer Menu */
		JPanel addComputerMenu = new JPanel();
		addComputerMenu.setLayout(new GridLayout(10, 1));
		JButton goToMainMenu = new JButton("<-");
		goToMainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(addComputerMenu);
				displayMainMenu(frame);
			}
		});

		JTextField fieldName = new JTextField();
		JTextField fieldserialNumber = new JTextField();
		JRadioButtonMenuItem jRadioMenuItem = new JRadioButtonMenuItem("Choix");
		jRadioMenuItem.setLayout(new GridLayout(1, 2));
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton ibmRadio = new JRadioButton("IBM", true);
		JRadioButton appleRadio = new JRadioButton("Apple");
		JRadioButton otherRadio = new JRadioButton("Other");
		buttonGroup.add(ibmRadio);
		buttonGroup.add(appleRadio);
		buttonGroup.add(otherRadio);
		JButton saveButton = new JButton("Enregistrer");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(addComputerMenu);
				displayMainMenu(frame);
				String brand = "0";
				if (ibmRadio.isSelected()) {
					brand = "1";
				} else if (appleRadio.isSelected()) {
					brand = "2";
				}
				MaterialInterface computer = addComputer(brand);
				computer.setName(fieldName.getText());
				computer.setSerialNumber(fieldserialNumber.getText());
				computersWriter.write(materials);
				
			}
		});
		jRadioMenuItem.add(ibmRadio);
		jRadioMenuItem.add(appleRadio);
		jRadioMenuItem.add(otherRadio);
		addComputerMenu.add(goToMainMenu);
		addComputerMenu.add(new JLabel("Nom de l'ordinateur"));
		addComputerMenu.add(fieldName);
		addComputerMenu.add(new JLabel("Numéro de série"));
		addComputerMenu.add(fieldserialNumber);
		addComputerMenu.add(jRadioMenuItem);
		addComputerMenu.add(saveButton);

		frame.add(addComputerMenu);
		frame.setVisible(false);
		frame.setVisible(true);
	}

	private void displayComputers(JFrame frame) {
		JPanel displayComputers = new JPanel();
		displayComputers.setLayout(new GridLayout(materials.size() + 1, 1));
		JButton goToMainMenu = new JButton("<-");
		goToMainMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(displayComputers);
				displayMainMenu(frame);
			}
		});
		displayComputers.add(goToMainMenu);
		for (int i = 0; i < materials.size(); i++) {
			displayComputers.add(new JLabel(i + " - " + materials.get(i)));

		}
		frame.add(displayComputers);
		frame.setVisible(false);
		frame.setVisible(true);
	}


	private void displayMenuRemoveComputer(Scanner sc) {
		if (materials.size() == 0) {
			System.out.println("Il n'y a pas d'ordinateur a supprimer");
			return;
		}
		System.out.println("Quel ordinateur souhaitez vous supprimer?");
		String computerId = sc.nextLine();
		removeComputer(Integer.valueOf(computerId));
		System.out.println("Ordinateur supprimé avec succés !!!");
	}

	private void displayMenuModifyComputer(Scanner sc) {
		if (materials.size() == 0) {
			System.out.println("Il n'y a pas d'ordinateur a modifier");
			return;
		}
		System.out.println("Quel ordinateur souhaitez vous modifier?");
		String computerId = sc.nextLine();
		System.out.println("Entrez le nom de l'ordinateur : ");
		String name = sc.nextLine();
		System.out.println("Entrez le numéro de série de l'ordinateur : ");
		String serialNumber = sc.nextLine();
		MaterialInterface computer = materials.get(Integer.valueOf(computerId));
		computer.setName(name);
		computer.setSerialNumber(serialNumber);

	}

	private MaterialInterface addComputer(String type) {

		switch (type) {
		case "1":
			materials.add(new IBMComputer());
			break;
		case "2":
			materials.add(new AppleComputer());
			break;
		default:
			materials.add( new DefaultComputer());

		}
		return materials.getLast();
	}

	private void removeComputer(int position) {
		materials.remove(position);
	}

}
