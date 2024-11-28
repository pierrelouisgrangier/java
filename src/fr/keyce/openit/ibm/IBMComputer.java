package fr.keyce.openit.ibm;

import fr.keyce.openit.Computer;

public class IBMComputer extends Computer {

	@Override
	public String toString() {
		return "IBM : " + super.toString();
	}

	@Override
	public String instructionsGame() {
		return "x86";
	}
}
