import java.util.regex.*;

public class Game {
    String outputtext;
    /*
    - 1 = leftArea, 2 = Bed, 3 = Bookshelf
    - 4 = Kitchen, 5 = Bathroom, 6 = Finale
    */
    int stage, phase;
    Player player;
    WelcomeScreen welcomescreen;
    Bed bed;
    Bookshelf bookshelf;
    Kitchen kitchen;
    Bathroom bathroom;
    Finale finale;
    Pattern pattern;
    Matcher matcher;
    final String inbetween;
    final String bedRegex, bookshelfRegex, bathroomRegex;
    final String kitchenRegex, doorRegex;
    private final static String newline = "\n";
    int gamestatus; //0 = in progress, 1 = win, 2 = loss
    
    public Game() {
        this.outputtext = "";
        this.stage = 0;
        this.phase = 0;
        this.gamestatus = 0;
        this.player = new Player();
        this.welcomescreen = new WelcomeScreen();
        this.bed = new Bed();
        this.bookshelf = new Bookshelf();
        this.kitchen = new Kitchen();
        this.bathroom = new Bathroom();
        this.finale = new Finale();
        this.inbetween = "Where do you wanna check next?";
        this.bedRegex = "(phone)|(note)|(leave)|(angry birds)|(Angry Birds)";
        this.bookshelfRegex = "(Superman)|(superman)|(key)|(wrench)|(Harry)|(harry)|(toolbox)|(leave)"
                            + "|(screws)|(duct tape)";
        this.bathroomRegex = "(pill)|(rug)|(cabinet)|(leave)|(toilet)|(key)|(liquor)|(poop)";
        this.kitchenRegex = "(sandwich)|(cabinet)|(clip)|(leave)|(bleach)";
        this.doorRegex = "(red key)|(combine)|(wrench and paperclips)|(wrench with paperclips)"
                        + "|(paperclips and wrench)|(paperclips with wrench)|(break)|(smash)"
                        + "|(wrench)|(penthouse)|(Penthouse)|(Four Seasons)|(four seasons)";
    }
    
    public void redo() {
        this.outputtext = "You can't do that right now. Give it another shot.\n";
    }
    
    public String event(String str) {
        if (this.stage == 0) {
            determineStage(str);
        }
        if (this.stage == 1) {
            if (this.phase == 0) {
                this.phase = 1;
                return bed.playIntro();
            }
            determinePhase(str);
            goBed(str);
        }
        else if (this.stage == 2) {
            if (this.phase == 0) {
                this.phase = 1;
                return bookshelf.playIntro();
            }
            determinePhase(str);
            goBookshelf(str);
        }
        else if (this.stage == 3) {
            if (this.phase == 0) {
                this.phase = 1;
                return kitchen.playIntro();
            }
            determinePhase(str);
            goKitchen(str);
        }
        else if (this.stage == 4) {
            if (this.phase == 0) {
                this.phase = 1;
                return bathroom.playIntro();
            }
            determinePhase(str);
            goBathroom(str);
        }
        else if (this.stage == 5) {
            if (this.phase == 0) {
                this.phase = 1;
                return finale.playIntro();
            }
            determinePhase(str);
            goFinale(str);
        }
        else {
            redo();
        }
        return this.outputtext;
    }
    
    public void determineStage(String str) {
        pattern = Pattern.compile("(bed)|(kitchen)|(bookshelf)|(bathroom)|(door)");
        matcher = pattern.matcher(str);
        if (matcher.find()) {
            if (matcher.group().equals("bed")) {
                this.stage = 1;
                this.phase = 0;
            }
            if (matcher.group().equals("bookshelf")) {
                this.stage = 2;
                this.phase = 0;
            }
            if (matcher.group().equals("kitchen")) {
                this.stage = 3;
                this.phase = 0;
            }
            if (matcher.group().equals("bathroom")) {
                this.stage = 4;
                this.phase = 0;
            }
            if (matcher.group().equals("door")) {
                this.stage = 5;
                this.phase = 0;
            }
        }
    }
    
    /*
    -Last phase is if there is no matching responses.
    -Phase 1 will always be for phase after intro and after you find something
    */
    public void determinePhase(String str) { 
        if (this.stage == 1) {
            pattern = Pattern.compile(this.bedRegex);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                if (matcher.group().equals("phone"))
                    this.phase = 2;
                else if (matcher.group().equals("note"))
                    this.phase = 3;
                else if (matcher.group().equals("leave"))
                    this.phase = 4;
                else if (matcher.group().equals("angry birds"))
                    this.phase = 6;
                else if (matcher.group().equals("Angry Birds"))
                    this.phase = 6;
                else
                    this.phase = 5;
            }
            else
                this.phase = 5;
        }
        else if (this.stage == 2) {
            pattern = Pattern.compile(this.bookshelfRegex);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                if (matcher.group().equals("Superman"))
                    this.phase = 2;
                else if (matcher.group().equals("superman"))
                    this.phase = 2;
                else if (matcher.group().equals("key"))
                    this.phase = 3;
                else if (matcher.group().equals("wrench"))
                    this.phase = 4;
                else if (matcher.group().equals("Harry"))
                    this.phase = 5;
                else if (matcher.group().equals("harry"))
                    this.phase = 5;
                else if (matcher.group().equals("toolbox"))
                    this.phase = 6;
                else if (matcher.group().equals("leave"))
                    this.phase = 7;
                else if (matcher.group().equals("screws"))
                    this.phase = 9;
                else if (matcher.group().equals("duct tape"))
                    this.phase = 10;
                else
                    this.phase = 8;
            }
            else
                this.phase = 8;
        }
        else if (this.stage == 3) {
            pattern = Pattern.compile(this.kitchenRegex);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                if (matcher.group().equals("sandwich"))
                    this.phase = 2;
                else if (matcher.group().equals("cabinet"))
                    this.phase = 3;
                else if (matcher.group().equals("clip"))
                    this.phase = 4;
                else if (matcher.group().equals("leave"))
                    this.phase = 5;
                else if (matcher.group().equals("bleach"))
                    this.phase = 7;
                else 
                    this.phase = 6;
            }
            else
                this.phase = 6;
        }
        else if (this.stage == 4) {
            pattern = Pattern.compile(this.bathroomRegex);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                if (matcher.group().equals("pill"))
                    this.phase = 2;
                else if (matcher.group().equals("cabinet"))
                    this.phase = 3;
                else if (matcher.group().equals("rug"))
                    this.phase = 4;
                else if (matcher.group().equals("toilet"))
                    this.phase = 5;
                else if (matcher.group().equals("key"))
                    this.phase = 6;
                else if (matcher.group().equals("leave"))
                    this.phase = 7;
                else if (matcher.group().equals("liquor"))
                    this.phase = 9;
                else if (matcher.group().equals("poop"))
                    this.phase = 10;
                else
                    this.phase = 8;
            }
            else
                this.phase = 8;
        }
        else if (this.stage == 5) {
            pattern = Pattern.compile(this.doorRegex);
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                if (matcher.group().equals("red key"))
                    this.phase = 2;
                else if (matcher.group().equals("combine"))
                    this.phase = 3;
                else if (matcher.group().equals("wrench and paperclips"))
                    this.phase = 3;
                else if (matcher.group().equals("wrench with paperclips"))
                    this.phase = 3;
                else if (matcher.group().equals("paperclips and wrench"))
                    this.phase = 3;
                else if (matcher.group().equals("paperclips with wrench"))
                    this.phase = 3;
                else if (matcher.group().equals("break"))
                    this.phase = 4;
                else if (matcher.group().equals("smash"))
                    this.phase = 4;
                else if (matcher.group().equals("wrench"))
                    this.phase = 5;
                else if (matcher.group().equals("penthouse"))
                    this.phase = 6;
                else if (matcher.group().equals("Penthouse"))
                    this.phase = 6;
                else if (matcher.group().equals("Four Seasons"))
                    this.phase = 6;
                else if (matcher.group().equals("four seasons"))
                    this.phase = 6;
                else if (matcher.group().equals("Four seasons"))
                    this.phase = 6;
                else if (matcher.group().equals("four Seasons"))
                    this.phase = 6;
                else
                    this.phase = 7;
            }
            else
                this.phase = 7;
        }
        else
            redo();
    }
    
    public void leaveArea() {
        this.outputtext = "If you want to head to the door just type 'go to the door', if you don't\n"
                        + "then just type the next area you would like to explore. You can check the\n"
                        + "bed, the bookshelf, the kitchen or the bathroom" + newline;
        this.outputtext += "Inventory:" + newline;
        if (player.havePhone())
            this.outputtext += "Cell Phone" + newline;
        if (player.haveNote())
            this.outputtext += "Note: 'Key.....Superman....bookshelf'" + newline;
        if (player.haveCabKey())
            this.outputtext += "Purple Key" + newline;
        if (player.haveHouseKey())
            this.outputtext += "Red Key" + newline;
        if (player.haveWrench())
            this.outputtext += "Wrench" + newline;
        if (player.ductTapeGrabbed())
            this.outputtext += "Duct tape" + newline;
        if (player.screwsGrabbed())
            this.outputtext += "Screws" + newline;
        if (player.haveClips())
            this.outputtext += "Paperclip" + newline;
        if (!player.havePhone() && !player.haveNote() && !player.haveHouseKey()
                && !player.haveCabKey() && !player.haveWrench() && !player.haveClips()
                && !player.screwsGrabbed() && !player.ductTapeGrabbed())
            this.outputtext += "You ain't got nothin." + newline;
        this.phase = 0;
        this.stage = 0;
    }
    
    public void goBed(String str) {
        if (this.phase == 2 && !player.havePhone()) { //phone
            player.grabPhone();
            this.outputtext = bed.grabPhone();
        }
        else if (this.phase == 2 && player.havePhone())
            this.outputtext = "You already have the phone.\n";
        else if (this.phase == 3 && !player.haveNote()) { //note
            player.grabNote();
            this.outputtext = bed.grabNote();
        }
        else if (this.phase == 3 && player.haveNote())
            this.outputtext = "You already have the note.\n";
        else if (this.phase == 4) //leave area
            leaveArea();
        else if (this.phase == 5)
            redo();
        else if (this.phase == 6 && !player.angryBirdsPlayed() && player.havePhone()) {
            player.playAngryBirds();
            this.outputtext = bed.playAngrybirds();
        }
        else if (this.phase == 6 && player.angryBirdsPlayed() && player.havePhone())
            this.outputtext = "You don't have time to play any more damn Angry Birds.\n";
        else if (this.phase == 6 && !player.angryBirdsPlayed() && !player.havePhone())
            this.outputtext = "You don't have the phone yet.\n";
            
    }
    public void goBookshelf(String str) {
        if (this.phase == 2 && !player.comicOpened()) { //superman
            player.openComic();
            this.outputtext = bookshelf.openComic();
        }
        else if (this.phase == 2 && player.comicOpened())
            this.outputtext = "You already opened the Superman comic.\n";
        else if (this.phase == 3 && player.comicOpened() && !player.haveCabKey()) {
            player.grabCabinetKey();
            this.outputtext = bookshelf.grabKey();
        }
        else if (this.phase == 3 && player.haveCabKey())
            this.outputtext = "You already have the purple key.\n";
        else if (this.phase == 3 && !player.comicOpened())
            this.outputtext = "The comic isn't opened yet.\n";
        else if (this.phase == 4 && player.toolboxOpened() && !player.haveWrench()) {
            player.grabWrench();
            this.outputtext = bookshelf.grabWrench();
        }
        else if (this.phase == 4 && player.haveWrench())
            this.outputtext = "You already have the wrench.\n";
        else if (this.phase == 4 && !player.toolboxOpened())
            this.outputtext = "The toolbox is shut.\n";
        else if (this.phase == 5 && !player.harryPotterOpened()) {
            player.openHarryPotter();
            this.outputtext = bookshelf.harryPotter();
        }
        else if (this.phase == 5 && player.harryPotterOpened())
            this.outputtext = "There is no time for this...Unfortunately.\n";
        else if (this.phase == 6 && !player.toolboxOpened()) {
            player.openToolbox();
            this.outputtext = bookshelf.openToolbox();
        }
        else if (this.phase == 6 && player.toolboxOpened())
            this.outputtext = "The toolbox is already open\n";
        else if (this.phase == 7)
            leaveArea();
        else if (this.phase == 8)
            redo();
        else if (this.phase == 9 && !player.screwsGrabbed() && player.toolboxOpened()) {
            player.grabScrews();
            this.outputtext = bookshelf.grabScrews();
        }
        else if (this.phase == 9 && player.screwsGrabbed() && player.toolboxOpened())
            this.outputtext = "You already have the screws.\n";
        else if (this.phase == 9 && !player.screwsGrabbed() && !player.toolboxOpened())
            this.outputtext = "The toolbox is closed.\n";
        else if (this.phase == 10 && !player.ductTapeGrabbed() && player.toolboxOpened()) {
            player.grabDuctTape();
            this.outputtext = bookshelf.grabDuctTape();
        }
        else if (this.phase == 10 && player.ductTapeGrabbed() && player.toolboxOpened())
            this.outputtext = "You have already grabbed the duct tape.\n";
        else if (this.phase == 10 && !player.ductTapeGrabbed() && !player.toolboxOpened())
            this.outputtext = "The toolbox is closed.\n";
    }
    
    public void goKitchen(String str) {
        if (this.phase == 2 && !player.sandwichGrabbed()){ // sandwich
            player.grabSandwich();
            this.outputtext = kitchen.grabSandwich();
        }
        else if (this.phase == 2 && player.sandwichGrabbed())
            this.outputtext = "You already took a bite. Move on Ryan!\n";
        else if (this.phase == 3 && !player.kitchenCabinetOpened() && player.haveCabKey()) { //cabinet
            player.openKitchenCabinet();
            this.outputtext = kitchen.openCabinet();
        }
        else if (this.phase == 3 && !player.kitchenCabinetOpened() && !player.haveCabKey())
            this.outputtext = "The cabinet seems to be locked.\n";
        else if (this.phase == 3 && player.kitchenCabinetOpened())
            this.outputtext = "You already opened the cabinet.\n";
        else if (this.phase == 4 && player.kitchenCabinetOpened() && !player.haveClips()) { //clips
            player.grabClips();
            this.outputtext = kitchen.grabClips();
        }
        else if (this.phase == 4 && !player.kitchenCabinetOpened() && !player.haveClips())
            this.outputtext = "The cabinet is locked.\n";
        else if (this.phase == 4 && player.haveClips())
            this.outputtext = "You already have the clips.\n";
        else if (this.phase == 7) {
            this.gamestatus = 2;
            this.outputtext = "You have died from drinking the bleach. Sorry. You lose.";
        }
        else if (this.phase == 5)
            leaveArea();
        else if (this.phase == 6)
            redo();
    }
    public void goBathroom(String str) {
        if (this.phase == 2 && player.bathroomCabinetOpened() && !player.pillsGrabbed()) {//pills
            player.grabPills();
            this.outputtext = bathroom.grabPills();
        }
        else if (this.phase == 2 && player.pillsGrabbed())
            this.outputtext = "You already looked at this pills.\n";
        else if (this.phase == 2 && !player.bathroomCabinetOpened())
            this.outputtext = "The cabinet is closed.\n";
        else if (this.phase == 3 && !player.bathroomCabinetOpened()){ //cabinet
            player.openBathroomCabinet();
            this.outputtext = bathroom.openCabinet();
        }
        else if (this.phase == 3 && player.bathroomCabinetOpened())
            this.outputtext = "The cabinet is already open.\n";
        else if (this.phase == 4 && !player.rugMoved()) { //rug
            player.moveRug();
            this.outputtext = bathroom.moveRug();
        }
        else if (this.phase == 4 && player.rugMoved())
            this.outputtext = "The rug has already been moved.\n";
        else if (this.phase == 5 & !player.toiletOpened()) { //toilet
            player.openToilet();
            this.outputtext = bathroom.openToilet();
        }
        else if (this.phase == 5 && player.toiletOpened())
            this.outputtext = "The toilet is already open.\n";
        else if (this.phase == 6 && !player.haveHouseKey() && player.toiletOpened()) { //key
            player.grabHouseKey();
            this.outputtext = bathroom.grabKey();
        }
        else if (this.phase == 6 && !player.toiletOpened() && !player.haveHouseKey())
            this.outputtext = "The toilet is closed.\n";
        else if (this.phase == 6 && player.haveHouseKey())
            this.outputtext = "You already have the red key.\n";
        else if (this.phase == 7) //leave
            leaveArea();
        else if (this.phase == 8)
            redo();
        else if (this.phase == 9 && !player.liquorDrank()) {
            player.grabLiquor();
            this.outputtext = bathroom.drinkLiquor();
        }
        else if (this.phase == 9 && player.liquorDrank())
            this.outputtext = "You have already drank the rest of the liquor.\n";
        else if (this.phase == 10 && !player.poopTaken()) {
            player.takePoop();
            this.outputtext = bathroom.takePoop();
        }
        else if (this.phase == 10 && player.poopTaken())
            this.outputtext = "Your bowel has already been vacated.\n";
    }
    public void goFinale(String str) {
        if (this.phase == 2 && player.haveHouseKey()) {
            player.openDoor();
            this.outputtext = finale.redKeySuccess() + newline + finale.findMarissa();
        }
        else if (this.phase == 2 && !player.haveHouseKey())
            this.outputtext = "You don't have the right key.\n";
        else if (this.phase == 3 && player.haveWrench() && player.haveClips()) {
            player.openDoor();
            this.outputtext = finale.pickedDoorSuccess() + newline + finale.findMarissa();
        }
        else if (this.phase == 3 && player.haveWrench() && !player.haveClips() ||
                 this.phase == 3 && !player.haveWrench() && player.haveClips())
            this.outputtext = "You don't have the combination materials.\n";
        else if (this.phase == 4)
            this.outputtext = finale.brokenDoorQuestion();
        else if (this.phase == 5 && player.haveWrench()) {
            player.openDoor();
            this.outputtext = finale.brokenDoorSuccess() + newline + finale.findMarissa();
        }
        else if (this.phase == 5 && !player.haveWrench())
            this.outputtext = "You have nothing to break the door with.\n";
        else if (this.phase == 6 && player.doorOpened()) {
            this.gamestatus = 1 ;
            this.outputtext = finale.youWon();
        }
        else if (this.phase == 6 && !player.doorOpened())
            this.outputtext = "You haven't opened the door yet!\n";
        else if (this.phase == 7)
            this.outputtext = "You are so close! Give it another shot.\n";
    }
    
    public int gameStatus() {
        return this.gamestatus;
    }
}
