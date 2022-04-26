import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_projecti {

	public static void main(String args[]) throws IOException {

		File Voices = new File("Voices.txt");
		int SumofVoices= 0;
		String Voicename2 = "";

		FileWriter VoicesList = new FileWriter("Voices");
		VoicesList.write("I'm an alien");
		//BufferedWriter Voiceslist2 = new BufferedWriter(new FileWriter("Voices.txt"));
		//Voiceslist2.write("Michael Jackson");
		//Voiceslist2.close();
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
					String VoiceName = "Voicename" + SumofVoices;
					Voicename2 = Name+ SumofVoices + ".txt";
					File VoiceName1 = new File(VoiceName);
					FileWriter VoicesList1 = new FileWriter(Voicename2);
					VoicesList.write(SumofVoices+Name+"\n");
					String IndexOfVoices=Integer.toString(SumofVoices);
					IndexOfVoices = Voicename2;
					SumofVoices++;
					
					File Voiceswithoutindex = new File("Voiceswithoutindex.txt");
					FileWriter VoicesList3 = new FileWriter("Voiceswithoutindex.txt");
					VoicesList3.write(Name+SumofVoices);
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
					Scanner VoicelineShower = new Scanner(Voicename2);
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
					FileWriter VoicelineWriter = new FileWriter(Voicename2, true);
					VoicelineWriter.write(SumOfVoiceLines + " " +in.nextLine() +"\n");
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
					Scanner Voices6 = new Scanner(Voices);

					while (Voices6.hasNextLine()) {
						Voice = Voices6.nextLine();
						System.out.println(Voice);
					}
					// code to modify files here. Possibly modifyFile()
					break;

				case 'G':
					System.out.println("Write the Voice in which you want to Delete a voice line");
					System.out.println("List of voices");
					Scanner Voices7 = new Scanner("Voices.txt");

					while (Voices7.hasNextLine()) {
						Voice = Voices7.nextLine();
						System.out.println(Voice);
					}
					System.out.println("Write the voice line you want to delete");
					System.out.println("List of voicelines within the voice");

					break;

				case 'H':
					System.out.println("Choose to delete a voice. Don't do it on a whim...");
					System.out.println("Pick the index of a voice");
					System.out.println("List of voices");
					Scanner Voices8= new Scanner("Voices.txt");

					while (Voices8.hasNextLine()) {
						Voice = Voices8.nextLine();
						System.out.println(Voice);
					}
					int IndexPicked=in.nextInt();
					final Scanner Voices10 = new Scanner(new File("Voiceswithoutindex.txt"));
					String VoicepickedbyIndex="";
					for (int y=0;y<=IndexPicked; y++) {
						 VoicepickedbyIndex= Voices10.nextLine();

					}
					Voices10.close();
					
					
					File NewFile = new File(VoicepickedbyIndex+"txt"); 
				    if (NewFile.delete()) { 
				      System.out.println("Deleted the folder: " + NewFile.getName());
				    } else {
				      System.out.println("Failed to delete the folder.");
				    } 
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

					double number = Math.random();
					long number2 = Math.round(number) * (VoicelineArray.size());
					int number3 = Math.toIntExact(number2);
					System.out.println(VoicelineArray[number3]);
					
					break;
				}

			}

			if (AnswerYesorNo.equals(("N"))) {
				break;
			}

		}
	}
}
