package theocv2;

public class Bed {
    String text;
    
    public Bed() {
        text = "";
    }
    
    public String playIntro() {
        this.text = "As you approach the bed, there isn't much to see but you notice on the bedside\n"
                    + "table that your phone is lying on it and the light atop it is blinking. The\n"
                    + "bedside table has a comic book on it but it looks as if it has some sort of note underneath.\n"
                    + "There is no time to rest in your comfortable bed though and dream of Marissa.\n"
                    + "What would you like to do?\n";
        return this.text;
    }
    
    public String grabPhone() {
        this.text = "You pick up the phone and open up your messages. You see that you\n"
                    + "have a message from Seth, your adoptive brother and best friend. The message reads\n"
                    + "'Ryan! You have to hurry up and get over here. We are at the Penthouse of the Four\n"
                    + "Seasons and this guy won't leave Marissa alone. Just get here man!' You place the phone\n"
                    + "in your pocket.\n";
        return this.text;
    }
    
    public String grabNote() {
        this.text = "You lift up the comic book and grab the note from underneath it. It's barely legible\n"
                    + "as it seems somebody has spilt a drink on it or something. But you are able to read a\n"
                    + "few words from it. It says 'Key....' and then a few lines later it reads\n"
                    + "'Superman...bookshelf'. You place the note in your pocket.\n ";
        return this.text;
    }
    
    public String playAngrybirds() {
        this.text = "You grab the phone out of your pocket and check to see if there are any cool apps on the phone.\n"
                + "You see Angry Birds on there. You don't have too much time so you will have to try and beat the high score\n"
                + "pretty quickly. A few minutes pass...still haven't topped the score yet. You give up only a\n"
                + "few thousand points short. Hopefully this isn't any indication of how the night is going to go.\n";
        return this.text;
    }
}
