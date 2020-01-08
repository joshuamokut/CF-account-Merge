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
	private static JLabel lbl1=new JLabel("Enter first account handle");
	private static JLabel lbl2=new JLabel("Enter second account handle");
	private static JLabel lbl3=new JLabel("Enter Minimum Rating");
	private static JLabel lbl4=new JLabel("Ignore this I'll get rid of it later");
	public static GridLayout grid;
	
	private static JLabel lbl5 =new JLabel();
	private static JLabel lbl5a =new JLabel();
	private static JLabel lbl[] =new JLabel[5];
	private static JButton openLink[]=new JButton[5];
	private String users[]=new String[10];

	private static int index=0;
	private String url[]=new String [5];

	
	
	public Home() throws HeadlessException{
		super();
		this.setTitle("Codeforces Solving App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		grid=new GridLayout(4, 2, 5, 5);
		GridLayout grid1=new GridLayout(5, 1, 2, 2);
		firstNick.setLayout(new FlowLayout());
		secondNick.setLayout(new FlowLayout());
		minRating.setLayout(new FlowLayout());
		maxRating.setLayout(new FlowLayout());
		
		lbl5.setLayout(grid1);
		
		for(int i=0; i<5; i++) {
			lbl[i]=new JLabel();
			lbl5.add(lbl[i]);
		}
		
		lbl5a.setLayout(grid1);
		
		for(int i=0; i<5; i++) {
			openLink[i]=new JButton();
			lbl5a.add(openLink[i]);
		}
		
		
		resetButton.setText("RESET");
		enterButton.setText("ENTER");
		
		firstNick.add(lbl1);
		secondNick.add(lbl2);
		minRating.add(lbl3);
		maxRating.setText("0");
		
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
		this.getContentPane().add(lbl5a);
		
		openLink[0].addActionListener(new ActionListener() {
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
					open(new URI(url[0]));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		openLink[1].addActionListener(new ActionListener() {
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
					open(new URI(url[1]));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		openLink[2].addActionListener(new ActionListener() {
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
					open(new URI(url[2]));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		openLink[3].addActionListener(new ActionListener() {
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
					open(new URI(url[3]));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
		});
		
		openLink[4].addActionListener(new ActionListener() {
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
					open(new URI(url[4]));
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
					for(int i=0; i<5; i++) {
						openLink[i].setText("Open Problem "+Integer.toString(Integer.parseInt(minRating.getText())+i*100));
					}
					
					try{
						JSONObject subarr[]=new JSONObject[2];
					
						for(int i=0; i<index; i++) {
							subarr[i]=getSubs(users[i]);

						}
						
						JSONObject probs=getProbs();
						for(int diff=0; diff<500; diff+=100) {
							Boolean ok1=false;

							for(int i=0; i<probs.getJSONObject("result").getJSONArray("problems").length(); i++) {
								JSONObject temp=probs.getJSONObject("result").getJSONArray("problems").getJSONObject(i);
								try {
									temp.getInt("rating");
								}
								catch(Exception e)
								{
									continue;
								}
								if (temp.getInt("rating")!=Integer.parseInt(minRating.getText())+diff) {
									continue;
								}
								Boolean ok=true;

								for(int j=0; (j<index) && ok; j++) {
									
									for(int k=0; k<subarr[j].getJSONArray("result").length(); k++) {

										JSONObject temp1=subarr[j].getJSONArray("result").getJSONObject(k);
											
										
										if (temp1.getString("verdict").equals("OK")) {
											if (temp1.getJSONObject("problem").getString("name").equals(temp.getString("name"))) {
												ok=false;
												break;
											}										
										}
									}
								}
								if (ok) {
									url[diff/100]="https://codeforces.com/problemset/problem/"+Integer.toString(temp.getInt("contestId"))+
											"/"+temp.getString("index");
									lbl[diff/100].setText(url[diff/100]);
									ok1=true;
									break;
								}
								
							}
							if (!ok1)
								lbl[diff/100].setText("nothing found");

						}
					}
					catch(Exception e){
						for(int i=0; i<5; i++) {
							lbl[i].setText("Something went wrong");

						}
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
				
				for(int i=0; i<5; i++) {
					lbl[i].setText("");
					openLink[i].setText("");
				}
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
