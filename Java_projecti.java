import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
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
		// BufferedWriter Voiceslist2 = new BufferedWriter(new
		// FileWriter("Voices.txt"));
		// Voiceslist2.write("Michael Jackson");
		// Voiceslist2.close();
		int SumOfVoiceLines = 0;

		while (true) {
			System.out.println("Modify voicebank script database? Y or N");
			Scanner in = new Scanner(System.in);
			String AnswerYesorNo = in.nextLine();

			if (AnswerYesorNo.equals("Y")) {
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

					

					VoicesList.write(SumofVoices + Name + "\n");

					SumofVoices++;

			
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
					Scanner VoicelineShower = new Scanner(Voice +".txt");
					while (VoicelineShower.hasNextLine()) {
						String Voiceline = VoicelineShower.next();
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

					VoicelineWriter.write(SumOfVoiceLines + " " + in.nextLine() + "\n");
					VoicelineWriter.close();
					Voices4.close();
					SumOfVoiceLines++;

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

					// Voice= (Voices5.nextLine());
					String VoiceChosen = in.nextLine();
					System.out.println("Type word/ words you want to involve in the voice line");
					if (Voice != "") {

						Scanner Voicelines = new Scanner(VoiceChosen + ".txt");
						String words = in.nextLine();
						String WordsSplit[] = words.split(" ");
						while (Voicelines.hasNext()) {
							String Voiceline = Voicelines.next();
							for (int i = 0; i < WordsSplit.length; i++) {
								if (Voiceline.contains(WordsSplit[i])) {

									if (i == (WordsSplit.length)) {
										System.out.println(in.nextLine());
									}
									Voicelines.close();
								}

								else {
									System.out.println("No Voiceline has all these words");
									Voicelines.close();
									break;
								}
							}
						}
					}
					Voices5.close();
					break;

				case 'F':
					System.out.println("Write the Voice in which you want to modify a voice line");
					System.out.println("List of voices");
					final Scanner Voices6 = new Scanner(new File("Voices.txt"));
					String VoicelineTroughIndex2 = "";

					while (Voices6.hasNextLine()) {
						Voice = Voices6.nextLine();
						System.out.println(Voice);
					}
					// code to modify files here. Possibly modifyFile()

					Scanner scnr2 = new Scanner(new FileInputStream(in.nextLine() + ".txt"));
					System.out.println("Voiceline within the voice");
					while (scnr2.hasNextLine()) {
						System.out.println(scnr2.nextLine());
					}
					System.out.println("Pick index of voiceline");
					int indexpicked4 = in.nextInt();

					for (int y = 0; y < indexpicked4; y++) {
						VoicelineTroughIndex2 = scnr2.nextLine();
					}
					System.out.println("Modify voiceline.");

					String NewModifiedVoiceline = in.nextLine();

					VoicelineTroughIndex2.replace(VoicelineTroughIndex2, NewModifiedVoiceline);

					scnr2.close();
					break;

				case 'G':
					System.out.println("Write the voice in which you want to delete a voiceline");
					System.out.println("List of voices");
					String VoicelineTroughIndex = "";
					final Scanner Voices7 = new Scanner(new File("Voices.txt"));

					while (Voices7.hasNextLine()) {
						Voice = Voices7.nextLine();
						System.out.println(Voice);
					}

					Scanner scnr = new Scanner(new FileInputStream(in.nextLine() + ".txt"));
					System.out.println("Voiceline within the voice");
					while (scnr.hasNextLine()) {
						System.out.println(scnr.nextLine());
					}
					System.out.println("Pick index of voiceline");
					int indexpicked3 = in.nextInt();

					for (int y = 0; y < indexpicked3; y++) {
						VoicelineTroughIndex = scnr.nextLine();
					}
					System.out.println("Do you want to delete the voiceline? Y or N");

					String AnswerYesorNo2 = in.nextLine();

					if (AnswerYesorNo2.equals("Y")) {

						VoicelineTroughIndex.replace(VoicelineTroughIndex, "");
					}

					if (AnswerYesorNo2.equals(("N"))) {
						System.out.println("Voiceline is still there!");
					}

					scnr.close();
					// String rivi;
	                    
				     // Scanner scan1 = new Scanner(System.in);
				      
				     // System.out.print("Enter the line to Delete: ");
				     // rivi = scan1.nextLine();
				      
				     // File file1 = new File(filename1 + ".txt");
				     // List<String> out1 = Files.lines(file1.toPath())
				                     //     .filter(line -> !line.contains(rivi))
				                     //     .collect(Collectors.toList());
				      //Files.write(file1.toPath(), out1, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

					break;

				case 'H':
					
					System.out.println("Choose to delete a voice. Don't do it on a whim...");
					
					// System.out.print("Enter the Name of File to Delete: ");
				    // filename = scan.nextLine();
				      
				     // File myfile = new File(filename+ ".txt");
					// if(myfile.delete()) {
				       //  System.out.println("\nThe file is deleted successfully!");
				    //  } else {
				     //    System.out.println("\nSomething went wrong!");
					
					
					System.out.println("Pick the index of a voice");
			
					System.out.println("List of voices");
					Scanner Voices8 = new Scanner("Voices.txt");
					
					while (Voices8.hasNextLine()) {
						Voice = Voices8.nextLine();
						System.out.println(Voice);
						
					}
					
					int IndexPicked = in.nextInt();
					final Scanner Voices10 = new Scanner(new File("Voiceswithoutindex.txt"));
					String VoicepickedbyIndex = "";
					for (int y = 0; y <= IndexPicked; y++) {
						VoicepickedbyIndex = Voices10.nextLine();

					}
					

					Voices10.close();

					File NewFile = new File(VoicepickedbyIndex + ".txt");
					if (NewFile.delete()) {
						System.out.println("Deleted the folder: " + NewFile.getName());
					} else {
						System.out.println("Failed to delete the folder.");
					}
					// File file = new File("Voices.txt");
				     // List<String> out = Files.lines(file.toPath())
				                       //   .filter(line -> !line.contains(filename))
				                         // .collect(Collectors.toList());
				     // Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
					
					// File file2 = new File("Voicelineswithoutindex.txt");
				     // List<String> out = Files.lines(file.toPath())
				                       //   .filter(line -> !line.contains(filename))
				                         // .collect(Collectors.toList());
				     // Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
					break;

				case 'I':
					System.out.println("Generating random voiceline...");
					Scanner Voices9 = new Scanner("Voices.txt");

					Scanner VoicelineScanner2 = new Scanner("VoiceLineCollection.txt");
					FileWriter VoiceLineCollection = new FileWriter("VoiceLineCollection.txt");
					List<String> VoicelineArray = new ArrayList<String>();
					while (Voices9.hasNext()) {
						Voice = Voices9.nextLine();
						{
							Scanner VoicelineScanner = new Scanner(Voice + "txt");

							while (VoicelineScanner.hasNextLine()) {
								VoiceLineCollection.write(VoicelineScanner.nextLine());
							}
							VoicelineScanner.close();
						}
					}

				{
					while (VoicelineScanner2.hasNext()) {

						VoicelineArray.add(VoicelineScanner2.next());
					}
				}

					double number = Math.random();
					long number2 = Math.round(number) * (VoicelineArray.size());
					int number3 = Math.toIntExact(number2);
					if (number3 >= 1) {
						System.out.println(VoicelineArray.get(number3 - 1));
					} else {
						System.out.println(VoicelineArray.get(number3));
					}
					in.close();
					break;
				}

			}

			if (AnswerYesorNo.equals(("N"))) {

				break;
			}

		}
	}
}
