import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Java_projecti {

	public static void main(String args[]) throws IOException {

		File Voices = new File("Voices.txt");
		int SumofVoices = 0;
		String Voicename2 = "";

		FileWriter VoicesList = new FileWriter("Voices");
		VoicesList.write("I'm an alien");
		int SumOfVoiceLines = 0;

		while (true) {
			System.out.println("Modify voicebank script database? Y or N");
			Scanner in = new Scanner(System.in);
			String AnswerYesorNo = in.nextLine();

			if (AnswerYesorNo.equals("Y") || AnswerYesorNo.equals("y")) {
				System.out.println("Question: Would you want to:");
				System.out.println("A) Add voice files to the bank");
				System.out.println("B) Show list of voices");
				System.out.println("C) Show list of voicelines within a voice");
				System.out.println("D) Add voicelines on the voices");
				System.out.println("E) Search voicelines on the bank");
				System.out.println("F) modify existing voicelines within a voice");
				System.out.println("G) Delete voicelines on the bank");
				System.out.println("H) Delete voices");
				System.out.println("I) Search a random voiceline");
				char Answer1 = in.next().charAt(0);
				in.nextLine();
				Answer1 = Character.toUpperCase(Answer1);
				switch (Answer1) {

				case 'A':
					VoicesList = new FileWriter("Voices.txt", true);
					System.out.println("Name of the Voice?");
					String Name = in.nextLine();
					String VoiceName = "Voicename";
					Voicename2 = Name + ".txt";
					File VoiceName1 = new File(VoiceName);
					FileWriter VoicesList1 = new FileWriter(Voicename2);
					VoicesList.write(Name+"\n");
					
					File Voiceswithoutindex = new File("Voiceswithoutindex.txt");
					FileWriter VoicesList3 = new FileWriter("Voiceswithoutindex.txt");
					VoicesList3.write(Name);
					VoicesList.close();
					break;

				case 'B':
					System.out.println("List of voices");
					final Scanner Voices2 = new Scanner(new File("Voices.txt"));
					while (Voices2.hasNext()) {
						System.out.println(Voices2.nextLine());

					}
					Voices2.close();
					break;

				case 'C':
					System.out.println("Write the Voice to see its voice lines");
					System.out.println("List of voices");
					final Scanner Voices3 = new Scanner(new File("Voices.txt"));
					while (Voices3.hasNext()) {
						String Voice = Voices3.nextLine();
						System.out.println(Voice);
					}
					String Voice = in.nextLine();
					Scanner VoicelineShower = new Scanner(new File(Voice+".txt"));
					while (VoicelineShower.hasNext()) {
						String Voiceline = VoicelineShower.nextLine();
						System.out.println(Voiceline);
					}
					Voices3.close();
					break;

				case 'D':

					System.out.println("Write the Voice to which you want to add a voiceline");
					System.out.println("List of voices");
					Scanner Voices4 = new Scanner(Voices);
					while (Voices4.hasNextLine()) {
						Voice = Voices4.nextLine();
						System.out.println(Voice);
					}
					Voice = in.nextLine();

					System.out.println("Write a voice line to add to the file");
					FileWriter VoicelineWriter = new FileWriter(Voice + ".txt", true);
					VoicelineWriter.write(" " +in.nextLine() +"\n");
					VoicelineWriter.close();
					Voices4.close();
					
					break;

				case 'E':
					System.out.println("Write the Voice in which you want to search a voice line");
					System.out.println("List of voices");
					Scanner Voices5 = new Scanner(Voices);
					Voice = "";
					

					while (Voices5.hasNextLine()) {
						Voice = Voices5.nextLine();
						System.out.println(Voice);
					}
					
					//Voice= (Voices5.nextLine());
					String VoiceChosen = in.nextLine();
					System.out.println("Type word/ words you want to involve in the voice line");
					if (Voice!= "") {
						
						Scanner Voicelines = new Scanner(VoiceChosen + ".txt");
						String words = in.nextLine();
						String WordsSplit[] = words.split(" ");
						while (Voicelines.hasNext()) {
							String Voiceline = Voicelines.next();
							for (int i = 0; i < WordsSplit.length; i++) {
								if (Voiceline.contains(WordsSplit[i])) {
									
										System.out.println(in.nextLine());
									}
									
								

								else {
									System.out.println("No Voiceline has all these words");
									
									break;
								}
							}
						}
					}
					
					break;

				case 'F':
					System.out.println("Write the Voice in which you want to modify a voice line");
					System.out.println("List of voices");
					final Scanner Voices6 = new Scanner(new File("Voices.txt"));
					
					while (Voices6.hasNextLine()) {
						Voice = Voices6.nextLine();
						System.out.println(Voice);
					}
					String filename2 = in.nextLine();
                    Scanner scnr4 = new Scanner(new FileInputStream(filename2 + ".txt"));
                    System.out.println("Voiceline within the voice");
                    while (scnr4.hasNextLine()) {
                        System.out.println(scnr4.nextLine());
                    }
                    String replace;
                    String eka;
				      Scanner scan3 = new Scanner(System.in);
				      
				      System.out.println("Enter the line to modify: ");
				      
				      File file4 = new File(filename2 + ".txt");
				      replace = scan3.nextLine();
				      System.out.println("Enter the new line: ");
				      eka = scan3.nextLine();
				      try (Stream<String> lines = Files.lines(file4.toPath())) {
				    	   List<String> replaced = lines
				    	       .map(line-> line.replaceAll(replace, eka))
				    	       .collect(Collectors.toList());
				    	   Files.write(file4.toPath(), replaced);
				    	}
				      System.out.println("Line successfully modified.");
					break;

				case 'G':
                    System.out.println("Write the voice in which you want to delete a voiceline");
                    System.out.println("List of voices");
                    final Scanner Voices7 = new Scanner(new File("Voices.txt"));
                    while (Voices7.hasNext()) {
                        System.out.println(Voices7.nextLine());
                        while (Voices7.hasNextLine()) {
                            Voice = Voices7.nextLine();
                            System.out.println(Voice);
                        }
                    }
                    String filename1 = in.nextLine();
                    Scanner scnr = new Scanner(new FileInputStream(filename1 + ".txt"));
                    System.out.println("Voiceline within the voice");
                    while (scnr.hasNextLine()) {
                        System.out.println(scnr.nextLine());
                    }
                    String rivi;
                    
				      Scanner scan1 = new Scanner(System.in);
				      
				      System.out.print("Enter the line to Delete: ");
				      rivi = scan1.nextLine();
				      
				      File file1 = new File(filename1 + ".txt");
				      List<String> out1 = Files.lines(file1.toPath())
				                          .filter(line -> !line.contains(rivi))
				                          .collect(Collectors.toList());
				      Files.write(file1.toPath(), out1, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
				      System.out.println("Line successfully deleted.");
                    
                    break;

				case 'H':
					System.out.println("Choose to delete a voice. Don't do it on a whim...");
					System.out.println("List of voices");
					Scanner Voices8= new Scanner(new File("Voices.txt"));
					while (Voices8.hasNext()) {
                        System.out.println(Voices8.nextLine());
                        while (Voices8.hasNextLine()) {
                            Voice = Voices8.nextLine();
                            System.out.println(Voice);
                        }
					}
					
					String filename;
				      Scanner scan = new Scanner(System.in);
				      
				      System.out.print("Enter the Name of File to Delete: ");
				      filename = scan.nextLine();
				      
				      File myfile = new File(filename+ ".txt");
				      
				      if(myfile.delete()) {
				         System.out.println("\nThe file is deleted successfully!");
				      } else {
				         System.out.println("\nSomething went wrong!");
				      }
				      File file = new File("Voices.txt");
				      List<String> out = Files.lines(file.toPath())
				                          .filter(line -> !line.contains(filename))
				                          .collect(Collectors.toList());
				      Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
				      
					break;

				case 'I':
					System.out.println("Generating random voiceline...");
					Scanner Voices9 = new Scanner("Voices.txt");
					FileWriter CollectionofVoices = new FileWriter("VoiceLineCollection.txt");
					Scanner CollectionofVoices2 = new Scanner("VoiceLineCollection.txt");
					List<String> VoicelineArray = new ArrayList<String>();
					while (Voices9.hasNext()) {
						Voice = Voices9.next();
						CollectionofVoices.write(Voice);
					}
					while (CollectionofVoices2.hasNext()) {

						VoicelineArray.add(CollectionofVoices2.next());
					}
					for(String voice:VoicelineArray)  
						  System.out.println(voice);
					double number = Math.random();
					long number2 = Math.round(number) * (VoicelineArray.size());
					int number3 = Math.toIntExact(number2);
					System.out.println(number3);
					
					break;
				}

			}

			if (AnswerYesorNo.equals("N") || AnswerYesorNo.equals("n")) {
				break;
			}

		}
	}
}
