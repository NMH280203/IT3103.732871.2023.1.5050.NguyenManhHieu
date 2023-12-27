// Nguyen Manh Hieu - 20215050
package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.ExceptionDialog;

public class DigitalVideoDisc extends Disc implements Playable{

	// Khởi tạo Constructor 
	public DigitalVideoDisc() {
		super();
		this.id = nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;
	}
	
	// ham boolean kiem tra title
		public boolean isMatch(String title) {
			return getTitle().equals(title);
		}
	
	// override toString
	@Override
	public String toString() {
		return "DVD - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " +
				getDirector() + " - " + getLength() + " minutes - " +
	               getCost() + " $";
	}
	
	public ArrayList<String> playToString() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Playing DVD: " + this.getTitle());
		output.add("DVD length: " + Integer.toString(this.getLength()));
		return output;	
	}
// Nguyen Manh Hieu 20215050
	public void play() throws PlayerException {
		try {
			if (this.getLength() > 0) {
				JDialog playDialog = new JDialog(new JFrame(), "Media Player");
				
				String playLabelText = "<html>";
				for(String label: playToString()) {
					playLabelText += label;
					playLabelText += "<br>";
				}
				playLabelText += "<html>";
				
				JLabel playLabel = new JLabel(playLabelText, SwingConstants.CENTER);
				playDialog.add(playLabel);
				playDialog.setLocation(200,200);
				playDialog.pack();
				playDialog.setVisible(true);
			}
			else {
				System.err.println();
				throw new PlayerException("ERROR: DVD length is non-posiive!");
			}
		}
		catch (PlayerException e){
			Exception ee = e;
			ExceptionDialog ed = new ExceptionDialog(ee);
			ed.getDialog();
		}
	}
	
	public void playJDialog() {
		JTextArea textArea = new JTextArea();
        textArea.append("Playing DVD: " + this.getTitle());
        textArea.append("\nTime: " + this.getLength());
        
        // Đặt thông tin văn bản trong hộp thoại
        JOptionPane.showMessageDialog(null, textArea, "DVD Information", JOptionPane.INFORMATION_MESSAGE);
	}

}
