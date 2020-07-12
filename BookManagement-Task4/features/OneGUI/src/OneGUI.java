import javax.swing.*;

import interfaces.IGUI;

import java.awt.*;

public class OneGUI implements IGUI {

	public JFrame getFrame(String title) {
		JFrame newFrame = new JFrame();
		newFrame.setTitle(title);
		newFrame.setLayout(new BorderLayout());
		newFrame.setBackground(Color.white);
		newFrame.setLocation(50,0);
		newFrame.setSize(700,600);
		newFrame.setMinimumSize(new Dimension(300,250));
		return newFrame;
	}
}
