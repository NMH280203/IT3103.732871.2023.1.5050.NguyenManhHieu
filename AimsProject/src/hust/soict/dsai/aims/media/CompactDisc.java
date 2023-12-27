package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.ExceptionDialog;
// Nguyen Manh Hieu - 20215050
public class CompactDisc extends Media implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	private String director;
	// getter
	public String getArtist() {
		return artist;
	}

	//Constructor
	public CompactDisc(String title,String category, String director, float cost, String artist) {
		super();
		this.title = title;
		this.category = category;
		this.artist = artist;
		this.cost = cost;
		this.setDirector(director);
		this.id = nbDigitalVideoDiscs++;

	}
	
	public CompactDisc(String title, String artist, List<Track> tracks, float cost) {
		super();
		this.title = title;
		this.artist = artist;
		this.tracks = tracks;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;

	}

	public CompactDisc(String title, String category, String artist, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.artist = artist;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;

	}
	
	public CompactDisc() {
		super();
		this.id = nbDigitalVideoDiscs++;

	}
	
	// Hàm thêm track
	public void addTrack(Track tr) {
		boolean check = true;
		for ( int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(tr.getTitle())) { // Kiểm tra xem track đã có hay chưa
				System.out.println("Track nay da ton tai");
				check = false;
				break;
			}
		}
		
		if (check) {
			tracks.add(tr);
			System.out.println("Track da duoc them vao");
		}
	}
	
	// Hàm xóa track
	public void removeTrack(Track tr) {
		boolean check = false;
		for ( int i = 0; i < tracks.size(); i++) {
			if ( tracks.get(i).getTitle().equals(tr.getTitle()) ) { // Kiểm tra track
				tracks.remove(i);
				System.out.println("Track da duoc xoa");
				check = true;
				break;
			}
		}
		if( !check ) {
			System.out.println("Track khong ton tai");
		}
	}
	
	// hàm tính thời lượng
	public int getLength() {
		int sum = 0;
		for ( int i = 0; i < tracks.size(); i++) {
			sum += tracks.get(i).getLength(); // cộng tổng các thời gian của từng track
		}
		return sum;
	}

	// hàm phát
	public ArrayList<String> playToString() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Playing CD: " + this.getTitle());
		output.add("Number of tracks: " + Integer.toString(this.tracks.size()));
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
				
				int count = 0;
				Iterator<Track> iter = tracks.iterator();
				Track nextTrack; 
				JDialog playDialogTrack = new JDialog(new JFrame(), "Media Player");;
				String playLabelTextTrack = "<html>Track " + Integer.toString(count) + ": playing...<html>";;
				JLabel playLabelTrack = new JLabel(playLabelTextTrack, SwingConstants.CENTER);;
				while(iter.hasNext()) {
					nextTrack = (Track) iter.next();
					playDialog.remove(playLabelTrack);
					playDialogTrack.dispose();
					nextTrack.play();
					count += 1;
					
					playDialogTrack = new JDialog(new JFrame(), "Media Player");
					
					playLabelTextTrack = "<html>Track " + Integer.toString(count) + ": playing...<html>";
					
					playLabelTrack = new JLabel(playLabelTextTrack, SwingConstants.CENTER);
					playDialog.add(playLabelTrack);
					playDialog.setLocation(200,200);
					playDialog.pack();
					playDialog.setVisible(true);
				}
			}
			else {
				throw new PlayerException("ERROR: CD length is non-positive!");
			}
		}
		catch (PlayerException e) {
			Exception ee = e;
			ExceptionDialog ed = new ExceptionDialog(ee);
			ed.getDialog();
		}
	}

	// override lại toString
	@Override
	public String toString() {
		return "CD - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getLength() + " minutes: " +
	               getCost() + " $";
	}
	
	// Hàm in danh sách track
	public void printTrack() {
		System.out.println("List track of this cd: ");
		for (int i = 0; i < tracks.size(); i++) {
			System.out.println("Track: " + tracks.get(i).getTitle() + ", length: " + tracks.get(i).getLength());
		}
	}
	
	
	// hàm phát
		public void playJDialog() {
			JTextArea textArea = new JTextArea();
	        textArea.append("Playing CD: " + this.getTitle());
	        textArea.append("\nFull-Time: " + this.getLength());
	        for ( int i = 0; i < tracks.size(); i++) {
		        textArea.append("\nPlaying Track: " + tracks.get(i).getTitle());
		        textArea.append("\nTime: " + tracks.get(i).getLength());
			}
	        // Đặt thông tin văn bản trong hộp thoại
	        JOptionPane.showMessageDialog(null, textArea, "CD Information", JOptionPane.INFORMATION_MESSAGE);
	    
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
