package fr.keyce.openit.apple;

import fr.keyce.openit.Computer;

public class AppleComputer extends Computer {
	
	@Override
	public String toString() {
		return "Apple : " + super.toString();
	}

	@Override
	public String instructionsGame() {
		return "ARM";
	}

}
