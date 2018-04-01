

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;

	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}

	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y,width,height);
			}

			String title = movie.getTitle();
			int year = movie.getYear();
			drawer.textSize(20);
			drawer.text(title + " (" + year + ")", x+3, y+30);
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}


	public void downloadArt(PApplet drawer) {

		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {
				// Find the cover art using IMDB links
				// Initialize coverArt

				Scanner scan = null;

				try {
					String imdb = movie.getIMDB();
					String pageURLString = "https://www.imdb.com/title/tt" + imdb + "/";

					URL pageURL = new URL(pageURLString);
					InputStream is = pageURL.openStream();
					scan = new Scanner(is);

					String fileData = "";
					while(scan.hasNextLine()) {
						String line = scan.nextLine();
						fileData += line + FileIO.lineSeparator;
					}
					System.out.println(fileData);
					//look for poster ==> look for src="
					//look for end "

					
					String imageURL = findImageURL(fileData);
					coverArt = drawer.loadImage(imageURL);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(scan != null)
						scan.close();
				}

			}

		});

		downloader.start();

	}
	
	private String findImageURL(String fileData) {

		String start = "Poster src=\"";
		String url = "";
		
		boolean found = false;
		int count = 0;
		
		for(int i = 0; i<fileData.length(); i++) {
			if(fileData.charAt(i) == start.charAt(count)) {
				count++;
				found = true;
			}
			else {
				found = false;
				count = 0;
			}
			if(count == start.length() && found == true) {
				int endQuote = fileData.indexOf("\"", i);
				url = fileData.substring(i, endQuote);
				
			}
		}
		return url;
	}


}
