import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bookManager.Book;
import bookManager.BookManager;
import bookManager.NewBookPanel;
import interfaces.Iview;

public class InfoPanel implements Iview {
	JButton infoButton;
	JButton closeBotton;
	BookManager mainBookManager;
	JFrame infoFrame;
	
	public JButton getButton(BookManager bookManager) {
		mainBookManager = bookManager;
		infoButton = new JButton("Info");
		ButtonListener listener = new ButtonListener();
		infoButton.addActionListener(listener);
		return infoButton;
	}

	public void showView(JFrame frame, Book infoBook) {
		infoFrame = frame;
		infoFrame.setTitle("Book Info");
		infoFrame.setBackground(Color.WHITE);
		infoFrame.setLayout(new BorderLayout());
		
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout( new BoxLayout(infoPanel, BoxLayout.Y_AXIS ));
		
		JLabel bookName = new JLabel(infoBook.getAllInfo());
		infoPanel.add(bookName);
		
		closeBotton = new JButton("Close");
		ButtonListener listener = new ButtonListener();
		closeBotton.addActionListener(listener);
		
		infoFrame.add(infoPanel, BorderLayout.CENTER);
		infoFrame.add(closeBotton, BorderLayout.SOUTH);

		
		infoFrame.setVisible(true);
	}
	
	class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == infoButton)
            {
            	showView(mainBookManager.getFrame("InfoPanal"), mainBookManager.getSelectedBook());
            }
            if(e.getSource() == closeBotton)
            {
            	infoFrame.dispose();
            }
        }
    }

}
