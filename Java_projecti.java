import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_projecti {

	public static void main(String args[]) throws IOException {
		FileWriter Voices = new FileWriter("Voices.txt");

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
				Answer1 = Character.toUpperCase(Answer1);
				switch (Answer1) {

				case 'A':
					System.out.println("Name of the Voice?");
					String Name = in.next();
					Voices.write(Name);

					break;

				case 'B':
					System.out.println("List of voices");
					Scanner Voices2 = new Scanner("Voices.txt");
					while (Voices2.hasNext()) {
						String Voice = Voices2.next();
						System.out.println(Voice);
					}
					break;

				case 'C':
					System.out.println("Write the Voice to see its voice lines");
					System.out.println("List of voices");
					Scanner Voices3 = new Scanner("Voices.txt");
					while (Voices3.hasNext()) {
						String Voice = Voices3.next();
						System.out.println(Voice);
					}
					String Voice = in.nextLine();
					Scanner VoicelineShower = new Scanner(Voice + ".txt");
					while (VoicelineShower.hasNext()) {
						String Voiceline = VoicelineShower.next();
						System.out.println(Voiceline);
					}
					break;

				case 'D':
					System.out.println("Choose a Voice to which you want to add a voiceline");
					System.out.println("List of voices");
					Scanner Voices4 = new Scanner("Voices.txt");
					while (Voices4.hasNext()) {
						Voice = Voices4.next();
						System.out.println(Voice);
					}
					Voice = in.nextLine();

					System.out.println("Write a voice line to add to the file");
					FileWriter VoicelineWriter = new FileWriter(Voice + ".txt");
					VoicelineWriter.write(in.nextLine());
					break;

				case 'E':
					System.out.println("Write the Voice in which you want to search a voice line");
					System.out.println("List of voices");
					Scanner Voices5 = new Scanner("Voices.txt");
					Voice = "";

					while (Voices5.hasNext()) {
						Voice = Voices5.next();
						System.out.println(Voice);
					}
					System.out.println("Type word/ words you want to involve in the voice line");
					if (Voice != "") {
						Scanner Voicelines = new Scanner(Voice + ".txt");
						String words = in.nextLine();
						String WordsSplit[] = words.split(" ");
						while (Voicelines.hasNext()) {
							String Voiceline = Voicelines.next();
							for (int i = 0; i < WordsSplit.length; i++) {
								if (Voiceline.contains(WordsSplit[i])) {

									if (i == (WordsSplit.length)) {
										System.out.println(in.nextLine());
									}
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
					Scanner Voices6 = new Scanner("Voices.txt");

					while (Voices6.hasNext()) {
						Voice = Voices6.next();
						System.out.println(Voice);
					}
					// code to modify files here. Possibly modifyFile()

				case 'G':
					System.out.println("Write the Voice in which you want to Delete a voice line");
					System.out.println("List of voices");
					Scanner Voices7 = new Scanner("Voices.txt");

					while (Voices7.hasNext()) {
						Voice = Voices7.next();
						System.out.println(Voice);
					}
					System.out.println("Write the voice line you want to delete");
					System.out.println("List of voicelines within the voice");

					break;

				case 'H':
					System.out.println("Choose to delete a voice. Don't do it on a whim...");

					break;

				case 'I':
					System.out.println("Generating random voiceline...");
					Scanner Voices8 = new Scanner("Voices.txt");
					FileWriter CollectionofVoices = new FileWriter("VoiceLineCollection.txt");
					Scanner CollectionofVoices2 = new Scanner("VoiceLineCollection.txt");
					List<String> VoicelineArray = new ArrayList<String>();
					while (Voices8.hasNext()) {
						Voice = Voices8.next();
						CollectionofVoices.write(Voice);
					}
					while (CollectionofVoices2.hasNext()) {

						VoicelineArray.add(CollectionofVoices2.next());
					}

					double number = (Math.random() * (VoicelineArray.size()));
					System.out.println(number);
					break;
				}
				break;

			}

			if (AnswerYesorNo.equals(("N"))) {
				break;
			}

		}
	}
}
