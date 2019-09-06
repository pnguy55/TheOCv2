package theocv2;

public class Finale {
    String text;
    
    public Finale() {
        this.text = "";
    }
    
    public String playIntro() {
        this.text = "You approach the door of the pool house. You are so close to reaching\n"
                + "Marissa. Now you just have to get the door open. What do you want do do?\n";
        return this.text;
    }
    
    public String redKeySuccess() {
        this.text = "You have successfully unlocked the door with the red key!";
        return this.text;
    }
    
    public String brokenDoorQuestion() {
        this.text = "What do you want to break it with?";
        return this.text;
    }
    
    public String brokenDoorSuccess() {
        this.text = "You have successfully broken through the door with the wrench!";
        return this.text;
    }
    
    public String pickedDoorSuccess() {
        this.text = "You have successfully picked the lock with the wrench and paperclip!";
        return this.text;
    }
    
    public String findMarissa() {
        this.text = "\nNow on to Marissa. Where do you want to go to find her?\n";
        return this.text;
    }
    
    public String youWon() {
        this.text = "\nYou successfully made it to the Four Seasons hotel and to "
                    + "Marissa before midnight. \nCongratulations for your triumphs!! You have "
                    + "been a hero once more and your \nrelationship with Marissa will live to fight another day.\n"
                    + " You also finally take the opportunity to jizz on her chest.";
        return this.text;
    }
}
