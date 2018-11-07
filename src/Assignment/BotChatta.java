package Assignment;

import java.util.Arrays;

public class BotChatta {
    public static void main(String[] args) {
        //creates new shit to begin chatbot
        Conversation conv = new Conversation();
        //declares music
        Music bgm = new Music();
        // plays music while programme is running
        Arrays.asList(new Thread(() -> conv.Conversation()), new Thread(() -> bgm.SoundMusic()))
                .parallelStream().forEach(x -> x.start());
    }
}