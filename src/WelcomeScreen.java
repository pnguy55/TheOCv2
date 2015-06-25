public class WelcomeScreen {
    String text;
    
    public WelcomeScreen() {
        this.text = "";
    }
    
    public String playIntro() {
        this.text = "     You find yourself, Ryan Atwood, locked in your own bedroom. Why do you ask?\n"
                + "Well your Aunt Hailey has locked you in because you were trying to be the responsible one\n"
                + "and look out for the house while your adoptive parents, Sandy and Kirsten Cohen, were out\n"
                + "for New Years Eve. There is only one problem. You are trying to get to your girlfriend,\n"
                + "Marissa, before the clock strikes midnight. But you don't know where she is because she wanted\n"
                + "to spend the night alone due the fight you had earlier that day. Oh, and you are locked in...\n"
                + "Your job is to find a way out of this pool house as well as find out where she is located so\n"
                + "you can get to her as possible.\n\n"
                + "Guidelines: \n"
                + "     You are able to check near the bed for something to help you out, near the bookshelf, the kitchen,\n"
                + "or the bathroom for anything you need. If you ever want to leave an area just type 'leave area'.\n"
                + "Also when you are ready to approach the glass doors of the pool house to make your escape, leave\n"
                + "area you are in and just type 'go to the door' and you will be able to leave.Be careful though,\n"
                + "there is no going back.\n\n"
                + "So let's get a move on. Which area of the pool house do you want to check first?\n";
        return this.text;
    }
}
