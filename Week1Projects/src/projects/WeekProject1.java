package projects;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.Date;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WeekProject1 {

	public static void main(String[] args)  {

		int findWord = 0;
		int countWord = 0;
			try {
		Console con = System.console();
			

		long currentTime = System.currentTimeMillis();
		Date time = new Date(currentTime);
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String cTime = sdf.format(time);
		System.out.println(cTime);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = Calendar.getInstance().getTime();
		String cDate = df.format(today);
		System.out.println(cDate);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileWriter("wordcount.txt",true));
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		if (args.length>2 || args.length<2) {
			con.writer().println("Please provide valid arguments: \n1.Path to text file\n2.Command to apply (wc or find)");
		}else {
			File f = new File(args[0]);
			
			if (!f.exists()) {
				con.writer().println(args[0] + " is not a valid file path");
			}else {
				con.writer().println( cTime + " File " + args[0] + " found!" );
			}

				if ( (!args[1].trim().equals("wc")) && (!args[1].trim().equals("find")) ) {
					con.writer().println("Argument \"" + args[1] + "\" is invalid, only \"wc\" and \"find\" are supported");

				}
				if (args[1].trim().equals("wc")) {
					con.writer().println(cTime + " word count started");
					BufferedReader br;
					try {
						br = new BufferedReader(new FileReader(args[0]));
						String line;
						line = br.readLine();
						while(line != null) {
							String[] wordList = line.split("\\s+");
							countWord += wordList.length;
							if (line.equals("")) {
								countWord -= wordList.length;
							}
							line = br.readLine();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					con.writer().println(cTime + " Word count finished. Counted " + countWord + " words");

					writer.append(String.format("%-12s %-10s %-5s %-12s %-10s", cDate, cTime, args[1], args[0], countWord));
					writer.append(System.getProperty( "line.separator" ));
					writer.close();
				}

				if (args[1].trim().equals("find")) {
					con.writer().println("Enter the word you wish to search in the file: ");
					BufferedReader br;
					Scanner sc = new Scanner(System.in);
					String word = sc.next();
					Pattern pat = Pattern.compile(word);
					try {
						br = new BufferedReader(new FileReader(args[0]));
						String line;
						line = br.readLine();
						while(line != null) {
							Matcher matcher = pat.matcher(line);
							while (matcher.find()) {
								findWord++;
							}
							line = br.readLine();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					con.writer().println(cTime + " Counting occurences of word \"" + word + "\"");
					con.writer().println(cTime + " Count of word \"" + word + "\" finished. Occurences found: " + findWord);
					writer.append(String.format("%-12s %-10s %-5s %-12s %-10s", cDate, cTime, args[1], args[0], word + ":" + findWord));
					writer.append(System.getProperty( "line.separator" ));
					writer.close();
				}
			}
			}catch (NullPointerException e) {
				System.out.println("NO Console");
			}
		}

	}





