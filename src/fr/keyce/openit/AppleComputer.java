package fr.keyce.openit;

public class AppleComputer extends Computer {

	public AppleComputer(Keyboard keyboard) {
		super(keyboard);
	}
	
	public void init() {
		super.setKeyboard(new Keyboard());
		super.setMouse(new Mouse());
	}

}
