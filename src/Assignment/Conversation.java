package Assignment;

import java.util.Scanner;

public class Conversation {
    static Scanner sc = new Scanner(System.in);
    static int option; static String[] Question; static String[][] response;static int noOfResponses,noOfQues;
    
    //Starts the programme
    public void Conversation(){ 
        do{
            showMenu();
            switch (option) {
                // option 1 - user creates question
                case 1: createQuestion();
                    break;
                case 2: Chatta();
                // option 2 - user talks to the bot
                    break;
                case 3: System.out.println("Chatta: Bye Bye ;-; (why are you leaving me?)");
                // option 3 - user exits the programme
                    break;
                default: System.out.print("Chatta: WAHHHHH I DON'T UNDERSTAND!!!\n>>>\t");
                // default - when a number that isn't an option is entered
                    break;
            }
        }while (option != 3);
    }
    
    //displays the options that can be chosen
    public static void showMenu(){ 
        System.out.print("Welcome to programme Chatta!\nChat with me before entering questions to see what I can do!"
                + "\nPlease select an option.\n1) Create Questions\n2) Chat with me\n3) Exit programme (whai ;_;...)"
                + "\n>>>\t");
            option = Integer.parseInt(sc.nextLine());
    }
    
    //user can create their own questions
    public static void createQuestion(){
        //asks how many questions and answers the user wants
        System.out.print("How maNy Questions do you want?\t");
        noOfQues = Integer.parseInt(sc.nextLine());
        System.out.print("How many Responses do you want?\t");
        noOfResponses = Integer.parseInt(sc.nextLine());
        //declares length the arrays
        Question = new String [noOfQues]; response = new String [noOfQues][noOfResponses];
        //assigns questions and answer to the corresponding arrays
        for(int i = 0; i < noOfQues; i++){
            System.out.print("Question: ");
            Question[i] = sc.nextLine();
            for( int x = 0 ; x < noOfResponses; x++){
                System.out.print("Answer "+(x+1)+" : ");
                response[i][x] = sc.nextLine();
            }
        }
        System.out.println("Thank you for entering your questions. If you choose to re-enter questions, please note that previous questions will not be stored.");
    }
    
    //finds the answer to the question they created
    public static String findQues(String you){ 
        //printed out when question is not found or created
        String resp = "ERROR ERROR MESSAGE NOT FOUND ERROR ERROR (maybe ask me something that I do know?)"; 
        //prints the response to the created question
        for( int y = 0; y < Question.length; y++){
            if (you.toLowerCase().contains(Question[y])){
                resp = response[y][(int)(Math.random()*(noOfResponses))];
        //printed when user wants to stop asking questions
            }else if (you.toLowerCase().contains("stop")){
                    resp = "Okies"; 
            }
        }
        return resp;
    }

    public static void Chatta(){
        String you, name;
        //default suggestions
        String[] song ={"Circles by Pierce the Veil", "YOUTH by Troye Sivan",
            "Sunrise by Our Last Night", "Same Old War by Our Last Night",
            "A Love Like War by All Time Low"};
        String[] quote = {"Be yourself; everyone else is already taken - Oscar Wilde",
            "A room without books is like a body without a soul - Marcus Tullius Cicero",
            "No one can make you feel inferior without your consent - Eleanor Roosevelt"};
        
        //asks for name
        System.out.println("Chatta: Please enter your name");
        System.out.print("You: ");
                name = sc.nextLine();
        // introductory sequence and small talk
        System.out.println("Chatta: Nice to meet you "+name+", my name is Chatta! Aside from answering questions, I offer random quotes (should you want them) and "
                + "give music suggestions (which is bias... my creator likes only certain genres) :D.\nEnter 'chat with me' to ask me your questions\nEnter 'bye' if you wish to leave me(...)"
                + "\nChatta: How was your day, "+ name+"?");
            System.out.print("You: ");
            you = sc.nextLine();
            if(you.toLowerCase().contains("good")||you.toLowerCase().contains("great")
                    ||you.toLowerCase().contains("excellent")) {
                System.out.println("Chatta: I hope you have more of those days :)");
            } else if (you.toLowerCase().contains("bad") ||you.toLowerCase().contains("horrible") || you.toLowerCase().contains("eh") ||
                    you.toLowerCase().contains("okay")|| you.toLowerCase().contains("aright")){
                    System.out.println("Chatta: Well I hope your day gets better :)");
            }else System.out.println("Chatta: I cannot comprehend what you are saying... me dumb sowwy ;-; but nonetheless I hope you have a great day!");

        //asks user what they want to do
        System.out.println("Chatta: Soooooo, what would you like me to do for you today?");
        do{
        System.out.print("You: ");
        you = sc.nextLine();
        //asking the questions they created
        if (you.toLowerCase().contains("chat")){
            System.out.println("Chatts: What do you want to ask me? (Enter 'stop' to stop asking questions)");
            do{
                System.out.print("You: ");
                you = sc.nextLine();
                System.out.println("Chatta: "+findQues(you));
            }while (!you.toLowerCase().contains("stop"));
            System.out.println("Chatta: What would you like for me to do for you now?");
        //giving song suggestions
        }else if (you.toLowerCase().contains("song")){
            System.out.println("Chatta: You should listen to "+song[0 + (int)(Math.random() * 5)]);
        //giving random quotes
        }else if (you.toLowerCase().contains("quote")){
            System.out.println("Chatta: "+quote[(int)(Math.random() * 3)]);
        //when the user says bye
        }else if (you.toLowerCase().contains("bye")){
            System.out.println("Chatta: Bye Bye ;-; (" + name+ ", why are you leaving me?)");
        }else System.out.println("Chatta: WAHHHHH I DON'T UNDERSTAND!!!");
        } while (!you.toLowerCase().contains("bye"));
        //goes back to the menu
    }

}