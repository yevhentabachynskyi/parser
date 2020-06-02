package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stock.AdobeParser;
import stock.DreamParser;
import stock.PixtaParser;
import stock.RF123Parser;
import stock.ShutterstockParser;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
 
public class StockController  implements Initializable {
	private AdobeParser adobeParser=new AdobeParser();
	private ShutterstockParser shutterParser =new ShutterstockParser();
	private PixtaParser pixtaParser = new PixtaParser();
	private DreamParser dreamParser = new DreamParser();
	private RF123Parser rf123Parser = new RF123Parser();
	@FXML
	   private ImageView adobeStock,shutterStock, pixtaStok, dreamStok, rf123Stok;
	@FXML
	   private ImageView adobeStop,shutterStop, pixtaStop, dreamStop, rf123Stop;
	@FXML
	ProgressIndicator adobeStatus,shutterStatus, pixtaStatus, dreamStatus, rf123Status;
	@Override
	   public void initialize(URL location, ResourceBundle resources) {
		adobeStatus.setVisible(false);
		shutterStatus.setVisible(false);
		pixtaStatus.setVisible(false);
		dreamStatus.setVisible(false);
		rf123Status.setVisible(false);
		

		adobeStock.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			int ask = JOptionPane.showConfirmDialog(null, "Are you sure?", "Attantion", JOptionPane.YES_NO_OPTION);
			if(ask!=0)
				return;
			adobeStatus.setVisible(true);
			new Thread() {
				public void run() {
					try {
						adobeParser.parseSite();
						} catch (IOException e) {
								// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					adobeStatus.setVisible(false);
			}
			}.start();
	        
	     });
		
		adobeStop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
	       	adobeStatus.setVisible(false);
	       	adobeParser.setRun(true);
	     });
		shutterStock.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			int ask = JOptionPane.showConfirmDialog(null, "Are you sure?", "Attantion", JOptionPane.YES_NO_OPTION);
			if(ask!=0)
				return;
	    shutterStatus.setVisible(true);
	        new Thread() {
				public void run() {
					try {
						shutterParser.parseSite();
						} catch (IOException e) {
								// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					shutterStatus.setVisible(false);
			}
			}.start();
	     });
		shutterStop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			shutterStatus.setVisible(false);
			shutterParser.setRun(true);
	        
	     });
		
		pixtaStok.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			int ask = JOptionPane.showConfirmDialog(null, "Are you sure?", "Attantion", JOptionPane.YES_NO_OPTION);
			if(ask!=0)
				return;
	    pixtaStatus.setVisible(true);
	        new Thread() {
				public void run() {
					try {
						pixtaParser.parseSite();
						} catch (IOException e) {
								// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					pixtaStatus.setVisible(false);
			}
			}.start();
	     });
		pixtaStop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			pixtaStatus.setVisible(false);
			pixtaParser.setRun(true);
	        
	     });
		dreamStok.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			int ask = JOptionPane.showConfirmDialog(null, "Are you sure?", "Attantion", JOptionPane.YES_NO_OPTION);
			if(ask!=0)
				return;
			dreamStatus.setVisible(true);
	        new Thread() {
				public void run() {
					try {
						dreamParser.parseSite();
						} catch (IOException e) {
								// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					dreamStatus.setVisible(false);
			}
			}.start();
	     });
		dreamStop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			dreamStatus.setVisible(false);
			dreamParser.setRun(true);
	        
	     });
		
		rf123Stok.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			int ask = JOptionPane.showConfirmDialog(null, "Are you sure?", "Attantion", JOptionPane.YES_NO_OPTION);
			if(ask!=0)
				return;
			rf123Status.setVisible(true);
	        new Thread() {
				public void run() {
					try {
						rf123Parser.parseSite();
						} catch (IOException e) {
								// TODO Auto-generated catch block
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					rf123Status.setVisible(false);
				}
			}.start();
	     });
		rf123Stop.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			rf123Status.setVisible(false);
			rf123Parser.setRun(true);
	        
	     });
	}
}