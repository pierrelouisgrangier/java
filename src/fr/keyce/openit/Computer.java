package fr.keyce.openit;

import fr.keyce.openit.apple.AppleComputer;
import fr.keyce.openit.ibm.IBMComputer;

public abstract class Computer implements MaterialInterface {

	public static Computer transformCsvToComputer(String line) {
		Computer computer = null;
		String[] elems = line.split(";");
		switch (elems[0]) {
		case "ibm":
			computer = new IBMComputer();
			break;
		case "apple":
			computer = new AppleComputer();
			break;
		default:
			computer = new DefaultComputer();
		}
		computer.setName(elems[1]);
		computer.setSerialNumber(elems[2]);
		return computer;
	}

	private String name;

	private String serialNumber;

	private Keyboard keyboard;

	private Mouse mouse;

	private float price;

	public Mouse getMouse() {
		return mouse;
	}

	protected Keyboard getKeyboard() {
		return keyboard;
	}

	void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	protected void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Computer " + name + " a le numéro de série : " + serialNumber;
	}

	public String toCSV() {
		return getType() + ";" + name + ";" + serialNumber;
	}

	@Override
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public abstract String instructionsGame();

	protected abstract String getType();

}
