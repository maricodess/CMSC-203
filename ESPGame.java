/*Class:CMSC 203
	*Instructor:Dr. Grigoriy Grinberg 
	*Description:
	*Due: 09/16/2024
	*Platform/compiler: Eclipse 
	* I pledge that I have completed the programming assignment 
	* independently. I have not copied the code from a student or any source. I have not given my code to any student.
	*Name:Mariela Andrade*/

package cmsc203_assignment1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ESPGame {
	public static void main(String[] args) {
		String[] colors = readColorsFromFile("src/colors.txt");
		
		if (colors == null || colors.length == 0) {
			System.out.println("No colors found in the file.");
			return;
			}
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int correctGuesses = 0;
		
		System.out.println("Here is the list of colors:");
		for (int i = 0; i < colors.length; i++) {
			System.out.println((i + 1) + ": " + colors[i]);
			}
		
		for (int round = 1; round <= 3; round++) {
			System.out.println("\nRound " + round);
			System.out.println("I am thinking of a color. Is it one of list of colors above?");
			
			int randomIndex = random.nextInt(colors.length);
					
					String selectedColor = colors[randomIndex];
			System.out.println("Enter your guess:");
			String userGuess = scanner.nextLine().trim().toLowerCase();
			
			if (userGuess.equalsIgnoreCase("exit")) {
				
				System.out.println("Exiting the game. Thank you for playing!");
				break;
				}
			
			if (userGuess.equals(selectedColor.toLowerCase())) {
				System.out.println("Correct! The color was " + selectedColor);
				
				correctGuesses++;
				} else {
					System.out.println("I was thinking of " + selectedColor);
					}
			}
		System.out.println("\nEnter your name:");
		String name = scanner.nextLine().trim();
		
		System.out.println("Enter a sentence that describes yourself:");
		String description = scanner.nextLine().trim();
		
		System.out.println("Enter the due date in MM/DD/YY format:");
		String dueDate = scanner.nextLine().trim();
		
		System.out.println("\nUser Information:");
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Due Date: " + dueDate);
		System.out.println("Number of correct guesses: " + correctGuesses);
		
		scanner.close();
		}
	
	private static String[] readColorsFromFile(String fileName) {
		String[] colors = new String[10];  
		
		int index = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			
			while ((line = br.readLine()) != null && index < colors.length) {
				
				String[] parts = line.split(" ", 2);
				if (parts.length == 2) {
					colors[index++] = parts[1].trim();
					}
				}
			br.close();
			} catch (IOException e) {
				System.out.println("Error reading the file: " + e.getMessage());
				}
		
		String[] result = new String[index];
		for (int i = 0; i < index; i++) {
			result[i] = colors[i];
			}
		return result;
		}
	}

