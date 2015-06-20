package theocv2;

public class Bathroom {
    String text;
    
    public Bathroom() {
        this.text = "";
    }
    
    public String playIntro() {
        this.text = "You walk into the normal bathroom keeping your eye out for anything that can be used\n"
                    + "to get out of this prison. You don't really know what could be in here. There is a\n"
                    + "cabinet above the sink that may have something inside of it. The rug seems to be moved as\n"
                    + "well. Other than that, you just notice the normal bathroom materials` lying around.\n"
                    + "What would you like to do first?\n";
        return this.text;
    }
    
    public String openCabinet() {
        this.text = "The door to the cabinet is now open and you notice a pill container that\n"
                    + "is not normally there. Also there is a small bottle of liquor sitting on the shelf.\n"
                    + "Seems as if Marissa has been here...\n";
        return this.text;
    }
    
    public String moveRug() {
        this.text = "You move the rug and notice some pills lying on the ground thinking\n"
                    + "that maybe Marissa has taken some and you need to get to her as soon as possible.\n";
        return this.text;
    }
    
    public String grabPills() {
        this.text = "You read the label and notice that they are pain killers and have the name\n"
                    + "Oliver Trask on them. What is going on here?\n";
        return this.text;
    }
    
    public String grabKey() {
        this.text = "You grab the red key and place it in your pocket.\n";
        return this.text;
    }
    
    public String openToilet() {
        this.text = "You open up the lid of the toilet tank and you notice that there is\n"
                    + "a red key taped to the underside of it.\n";
        return this.text;
    }
    
    public String drinkLiquor() {
        this.text = "You grab the bottle of liquor and notice that there is a tiny bit of\n"
                    + "vodka left at the bottom. This probably isn't a good time for you to\n"
                    + "be drinking but you go ahead and down the rest of it to ease some of\n"
                    + "the weight off your shoulders. Now that you are feeling better, it's\n"
                    + "time to get back to business.\n";
        return this.text;
    }
    
    public String takePoop() {
        this.text = "Don't you think that you can hold it? If you really have to go then I\n"
                + " guess you can. You sit down on the toilet and are determined to take the\n"
                + "fastest crap of all time. You need to relieve those gut pains that way your\n"
                + "moment with Marissa will be that much sweeter.\n";
        return this.text;
    }
}
