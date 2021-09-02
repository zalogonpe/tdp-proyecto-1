package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		Student estudiante;
		estudiante=new Student(114128, "Perez", "Gonzalo Nicolas", "zalogonpe@hotmail.com", "https://github.com/zalogonpe", "/images/Gonzalo.png");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen gui=new SimplePresentationScreen(estudiante);
            	gui.setVisible(true);
            }
        });
    }
}