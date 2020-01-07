package codeforcesSolving;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


import javax.swing.JFrame;

import org.json.JSONObject;

import javax.swing.*;

@SuppressWarnings("serial")
public class Home extends JFrame{
	private static JTextField firstNick=new JTextField();
	private static JTextField secondNick=new JTextField();
	private static JTextField minRating=new JTextField();
	private static JTextField maxRating=new JTextField();
	private static JButton resetButton=new JButton();
	private static JButton enterButton=new JButton();
	private static JButton openLink=new JButton("Open Problem");
	private static JLabel lbl1=new JLabel("Enter first account handle");
	private static JLabel lbl2=new JLabel("Enter second account handle");
	private static JLabel lbl3=new JLabel("Enter Minimum Rating");
	private static JLabel lbl4=new JLabel("Enter Maximum Rating");
	public static GridLayout grid;
	private static JLabel lbl5 =new JLabel();
	private static int index=0;
	private String users[]=new String[10];
	private String url="";
	
	
	
	public Home() throws HeadlessException{
		super();
		this.setTitle("Codeforces Solving App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		grid=new GridLayout(4, 2, 5, 5);
		
		firstNick.setLayout(new FlowLayout());
		secondNick.setLayout(new FlowLayout());
		minRating.setLayout(new FlowLayout());
		maxRating.setLayout(new FlowLayout());
		resetButton.setText("RESET");
		enterButton.setText("ENTER");
		
		firstNick.add(lbl1);
		secondNick.add(lbl2);
		minRating.add(lbl3);
		maxRating.add(lbl4);
		
		firstNick.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
				{
					lbl1.setVisible(false);
				}
				else {
					if (firstNick.getText().isEmpty()) {
						lbl1.setVisible(true);
					}
				}
			}
			
		});
		
		secondNick.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
				{
					lbl2.setVisible(false);
				}
				else {
					if (secondNick.getText().isEmpty()) {
						lbl2.setVisible(true);
					}
				}
			}
			
		});
		
		minRating.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
				{
					lbl3.setVisible(false);
				}
				else {
					if (minRating.getText().isEmpty()) {
						lbl3.setVisible(true);
					}
				}
			}
			
		});
		
		maxRating.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyChar()!=KeyEvent.VK_BACK_SPACE)
				{
					lbl4.setVisible(false);
				}
				else {
					if (maxRating.getText().isEmpty()) {
						lbl4.setVisible(true);
					}
				}
			}
			
		});
		
		this.setLayout(grid);
		
		this.getContentPane().add(firstNick);
		this.getContentPane().add(secondNick);
		this.getContentPane().add(minRating);
		this.getContentPane().add(maxRating);
		this.getContentPane().add(resetButton);
		this.getContentPane().add(enterButton);
		this.getContentPane().add(lbl5);
		this.getContentPane().add(openLink);
		
		openLink.addActionListener(new ActionListener() {
			private void open(URI uri) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(uri);
					}catch(Exception e) {
						lbl5.setText("Oops, an error has occured");
					}
				}
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					open(new URI(url));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		});
		enterButton.addActionListener(new ActionListener() {

			public Boolean isNumeric(String s) {
				if (s.isEmpty())
				{
					return false;
				}
				try {
					Integer.parseInt(s);
				}catch(NumberFormatException nfe) {
					return false;
				}
				return true;
			}
			
			public Boolean CheckUser(String handle) throws Exception{
				if (handle.isEmpty())
					return false;
				
				URL obj= new URL("https://codeforces.com/api/user.info?handles="+handle);
				HttpURLConnection con=(HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response= new StringBuffer();
				while((inputLine=in.readLine())!=null) {
					response.append(inputLine);
				}
				in.close();
				JSONObject myresponse=new JSONObject(response.toString());
				
				return myresponse.getString("status").equals("OK");
				
			}
			
			public Boolean validate() {
				//validate ratings
				try {
					Boolean ok1=CheckUser(firstNick.getText());
					Boolean ok2=CheckUser(secondNick.getText());
					
					if (!ok1 && !ok2) {
						lbl5.setText("Please enter at least one valid handle");
						return false;
					}
					if (!ok1 && !firstNick.getText().isEmpty()) {
						lbl5.setText("User handle does not exist");
						return false;		
					}
					if (!ok2 && !secondNick.getText().isEmpty()) {
						lbl5.setText("User handle does not exist");
						return false;		
					}
					
					if (!isNumeric(minRating.getText())) {
						lbl5.setText("Minimum Rating must be a number");
						return false;						}
					if (!isNumeric(maxRating.getText())) {
						lbl5.setText("maximum Rating must be a number");
						return false;				
					}
					lbl5.setText("");
					
					index=0;
					
					if (ok1) {
						users[index]=firstNick.getText();
						index++;
					}
					if (ok2) {
						users[index]=secondNick.getText();
						index++;
					}
					return true;
				}
				catch (Exception e) {
					lbl5.setText("Check handles again");
					return false;
				}
				
			}
			
			JSONObject getSubs(String handle) throws Exception{
				URL obj= new URL("https://codeforces.com/api/user.status?handle="+handle+"&from=1&count=2000");
				HttpURLConnection con=(HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response= new StringBuffer();
				while((inputLine=in.readLine())!=null) {
					response.append(inputLine);
				}
				in.close();
				JSONObject myresponse=new JSONObject(response.toString());
				return myresponse;
			}
			
			JSONObject getProbs() throws Exception{
				URL obj= new URL("https://codeforces.com/api/problemset.problems?");
				HttpURLConnection con=(HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response= new StringBuffer();
				while((inputLine=in.readLine())!=null) {
					response.append(inputLine);
				}
				in.close();
				JSONObject myresponse=new JSONObject(response.toString());
				return myresponse;
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (validate()) {
					try{
						JSONObject subarr[]=new JSONObject[2];
					
						for(int i=0; i<index; i++) {
							subarr[i]=getSubs(users[i]);
						}
						
						JSONObject probs=getProbs();
						for(int i=0; i<probs.getJSONObject("result").getJSONArray("problems").length(); i++) {
							JSONObject temp=probs.getJSONObject("result").getJSONArray("problems").getJSONObject(i);
							if (temp.getInt("rating")!=Integer.parseInt(minRating.getText())) {
								continue;
							}

							Boolean ok=true;
							for(int j=0; (j<index )&& ok; j++) {
								
								for(int k=0; k<subarr[j].getJSONArray("result").length(); k++) {
									JSONObject temp1=subarr[j].getJSONArray("result").getJSONObject(k);
									
									if (temp1.getString("verdict").equals("OK")) {
										if (temp1.getJSONObject("problem").get("index").equals(temp.get("index")) && (temp1.getJSONObject("problem").getInt("contestId") ==temp.getInt("contestId"))) {
											ok=false;
											break;
										}
												
											
										
									}
								}
							}
							if (ok) {
								url="https://codeforces.com/problemset/problem/"+Integer.toString(temp.getInt("contestId"))+
										"/"+temp.getString("index");
								lbl5.setText(url);
								return;
							}
							
						}
						lbl5.setText("nothing found");
						
					}
					catch(Exception e){
						lbl5.setText("Something went wrong");
					}
					
				}
			}
			
		});
		
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				firstNick.setText("");
				lbl1.setVisible(true);
				
				secondNick.setText("");
				lbl2.setVisible(true);
				
				minRating.setText("");
				lbl3.setVisible(true);
				
				maxRating.setText("");
				lbl4.setVisible(true);
				
				lbl5.setText("");
				index=0;
			}
			
		});
		
		setBounds(0, 0, 700, 600);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Home app=new Home();
				app.setVisible(true);
			}
			
		});

	}

}
