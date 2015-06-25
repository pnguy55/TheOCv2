public class Bookshelf {
    String text;
    
    public Bookshelf() {
        this.text = "";
    }
    
    public String playIntro() {
        this.text = "You walk over to the bookshelf that was filled with different books and comics\n"
                    + "before you even moved into the Cohen's pool house. There is an assortment of different things\n"
                    + "lying on the ground around it. You notice that there is a toolbox lying next to it\n"
                    + "as well.\n"
                    + "What do you want to do next?\n";
        return this.text;
    }
    
    public String openComic() {
        this.text = "You grab the Superman comic and place it on the table wondering if the\n"
                    + "key is actually in there like it is supposed to be. You turn the pages and notice\n"
                    + "that there is a purple key!\n";
        return this.text;
    }
    
    public String grabKey() {
        this.text = "You now have the purple key but you don't really know what it is for. You can test it\n"
                    + "out on different doors.\n";
        return this.text;
    }
    
    public String openToolbox() {
        this.text = "You open up the toolbox and notice that there really is not very much in there\n"
                    + "but a few screws, a tension wrench, and a roll of duct tape.\n";
        return this.text;
    }
    
    public String grabWrench() {
        this.text = "You now have the tension wrench. Maybe that can be used for something.\n";
        return this.text;
    }
    
    public String harryPotter() {
        this.text = "You grab Harry Potter and The Goblet of Fire. You stop and think for a second\n"
                    + "about Emma Watson but then you jump back into reality realizing what has to be done!\n";
        return this.text;
    }
    
    public String grabScrews() {
        this.text = "You now have the screws. Not really sure if you can get anything done with these but you\n"
                    + "have them anyway.\n";
        return this.text;
    }
    
    public String grabDuctTape() {
        this.text = "You now have the duct tape. Don't forget you are trying to break out of here, not repair the\n"
                    + "damn place.\n";
        return this.text;
    }
}
