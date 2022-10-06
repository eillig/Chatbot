/**
*  A Java Chatbot to respond to user input
* @author: Emma Illig
* @version: Spring 2022
*/
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;


class Conversation {
  /** Complies and runs conversation program */
  public static void main(String[] arguments) {
    /** Creates random integer to choose from lsit of responses*/
    Random rand = new Random();
    /** Array list to store copy of transcript */
    List<String> transcript = new ArrayList<>();
    /** Scanner to store user input */
    Scanner in = new Scanner(System.in);

    /** String array to store initial prompt */
    String[] starters = {"Hi, how are you?", "Hello", "How's the weather?", "Nice to meet you, tell me about yourself.", "Howdy!", "What's your favorite color?", "Who's your favorite pop star?"};
    /** String array to store responses */
    String[] responses = {"Wow!", "Tell me more", "That's neat.", "Mhm", "Interesting.", "Really?", "Me too!", "I wouldn't have guessed.", "Why?"};

    /** Takes and stores user input for converstaion rounds*/
    System.out.println("How many rounds of conversation would you like?");
    Double numRounds = in.nextDouble();
    
    
    /** Pulls random starter form array, prints and adds to transcript*/
    String first = starters[rand.nextInt(5)];
    System.out.println(first);
    transcript.add(first);

    /** Prints and stores user response for given number of rounds */
    for (int i = 1; i <= numRounds; i++) {
      Scanner convo = new Scanner(System.in);
      String next = convo.nextLine();
      transcript.add(next);
    
    /** Finds and replaces mirror words */
      String replacedString = "";
      String[] replaced = next.split(" ");
      for (int j = 0; j < replaced.length; j++){
        if (replaced[j].equals("you")) {
          replaced[j] = "I";
          replacedString = replacedString + replaced[j] + " ";}
        else if (replaced[j].equals("your")){
          replaced[j] = "my";
          replacedString = replacedString + replaced[j] + " ";
          }
        else if (replaced[j].equals("I")){
          replaced[j] = "you";
          replacedString = replacedString + replaced[j] + " ";
          }
        else if (replaced[j].equals("me")){
          replaced[j] = "you";
          replacedString = replacedString + replaced[j] + " ";
          }
        else if (replaced[j].equals("am")){
          replaced[j] = "are";
          replacedString = replacedString + replaced[j] + " ";
          }
        else if (replaced[j].equals("my")){
          replaced[j] = "your";
          replacedString = replacedString + replaced[j] + " ";
          }
        else if (replaced[j].equals("I'm")){
          replaced[j] = "you're";
          replacedString = replacedString + replaced[j] + " ";
        }
        else if (replaced[j].equals("you're")){
          replaced[j] = "I'm";
          replacedString = replacedString + replaced[j] + " ";
        }
        else {replacedString = replacedString + replaced[j] + " ";}}

    int replacedLength = replacedString.length() -1;

    /** Takes the space off the end of new string for ease of comparison*/
    String shortened = replacedString.substring(0,replacedLength);

    /** Prints random response or mirrors user */
    if (shortened.equals(next)) {
      String response = responses[rand.nextInt(6)];
      System.out.println(response);
      transcript.add(response);
      }
    else{
      System.out.println(replacedString);
      transcript.add(replacedString);
      }
    };

  System.out.println("See ya!");

    /** Generate Transcript*/
    System.out.println();
    System.out.println("TRANSCRIPT:");
    for (int i = 0; i < transcript.size(); i++){
      System.out.println(transcript.get(i));
      };
    

  }
}