import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer[] listOfNumbers = {1, 2, 3, 4, 5};
        String separator = ",";
        String fileName = "nGramLearning.txt";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String[] nGrams = scanner.nextLine().split(",");

        ArrayList<NGram> ngramList = new ArrayList<>();

        for (Integer num : listOfNumbers) {
            NGram nGram = new NGram(num);
            float totalAppearances = 0;
            float num1 = 0;
            float num2 = 0;
            float num3 = 0;
            float num4 = 0;
            float num5 = 0;
            for (int i = 0; i < nGrams.length; i++) {
                if (num.equals(Integer.parseInt(nGrams[i]))) {
                    totalAppearances++;
                    if (i < nGrams.length - 1) {
                        int next = Integer.parseInt(nGrams[i + 1]);
                        if (next == 1) {
                            num1++;
                        } else if (next == 2) {
                            num2++;
                        } else if (next == 3) {
                            num3++;
                        } else if (next == 4) {
                            num4++;
                        } else if (next == 5) {
                            num5++;
                        }
                    }
                }
            }

            if (totalAppearances != 0) {
                nGram.setProb1(num1 / totalAppearances);
                nGram.setProb2(num2 / totalAppearances);
                nGram.setProb3(num3 / totalAppearances);
                nGram.setProb4(num4 / totalAppearances);
                nGram.setProb5(num5 / totalAppearances);

            }
            ngramList.add(nGram);
        }
        int aiGuess;
        if (ngramList.size() == 0) {
            Random random = new Random();
            aiGuess = random.nextInt(6);
        } else {
            int lastNumber = Integer.parseInt(nGrams[nGrams.length - 1]);
            NGram nGram = ngramList.get(lastNumber - 1);

            float probability = nGram.getProb1();
            aiGuess = 1;

            if(probability < nGram.getProb2()){
                probability = nGram.getProb2();
                aiGuess = 2;
            }

            if(probability < nGram.getProb3()){
                probability = nGram.getProb3();
                aiGuess = 3;
            }

            if(probability < nGram.getProb4()){
                probability = nGram.getProb4();
                aiGuess = 4;
            }

            if(probability < nGram.getProb5()){
                aiGuess = 5;
            }
        }

        scanner = new Scanner(System.in);
        System.out.println("Please think of a number between 1 and 5 inclusive");

        int number = scanner.nextInt();
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write(number + separator);
        fileWriter.close();
        System.out.println("AI guess for that number: " + aiGuess);

        if (number == aiGuess) {
            System.out.println("Guess was correct!");
        } else {
            System.out.println("Guess was not correct!");
        }
    }
}
