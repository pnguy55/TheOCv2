package theocv2;

public class Kitchen {
    String text;
    
    public Kitchen() {
        this.text = "";
    }
    
    public String playIntro() {
        this.text = "You make your way to the kitchen. You don't really use this kitchen\n"
                    + "and have not really explored it that much. Marissa, on the other hand, likes to use it and\n"
                    + "cook for you. There is a half-eaten ham sandwich lying next to the sink. The cabinet\n"
                    + "underneath the sink may have something in it but you don't really know because you have\n"
                    + "not opened it before. It seems to be locked as well.\n"
                    + "What do you want to do first?\n";
        return this.text;
    }
        
    public String openCabinet() {
        this.text = "You open up the cabinet with the purple key but the door falls off. Need to repair that but maybe\n"
                    + "another time. Inside the cabinet, you notice a paperclip and some bleach\n"
                    + "that has never even been opened. Seems to be some detergent that can burn\n"
                    + "something maybe? Who knows.\n";
        return this.text;
    }
        
    public String grabClips() {
        this.text = "You now have the paperclip.\n";
        return this.text;
        }
        
    public String grabSandwich() {
        this.text = "You grabbed the sandwich and just assumed it was still good. You take a bite\n"
                    + "from it. Tastes really good, actually. Even though that was delicious it doesn't\n"
                    + "really help you at all.\n";
        return this.text;
    }
}
