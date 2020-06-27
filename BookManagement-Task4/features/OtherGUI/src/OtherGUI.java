import javax.swing.*;

import interfaces.IGUI;

import java.awt.*;

public class OtherGUI implements IGUI {

	public JFrame getFrame(String title) {
		JFrame newFrame = new JFrame();
		newFrame.setTitle(title);
		newFrame.setLayout(new BorderLayout());
		newFrame.setLocation(50,0);
		newFrame.setSize(1000,1000);
		newFrame.setBackground(Color.red);
		newFrame.setMinimumSize(new Dimension(300,250));
		return newFrame;
	}
}
