package theocv2;

public class Player {
    /*
    -Items to grab
    */
    private Boolean wrench, housekey, cabinetkey;
    private Boolean clips, note, phone, screws, ducttape;
    
    /*
    -Interaction checks
    */
    private Boolean toilet, comic, bathroomcabinet, toolbox;
    private Boolean kitchencabinet, harrypotter, sandwich;
    private Boolean rug, pills, door, poop, liquor, angrybirds;
    
    private String name;
    
    public Player() {
        this.name = "Ryan Atwood";
        this.wrench = true;
        this.housekey = false;
        this.cabinetkey = true;
        this.clips = false;
        this.note = false;
        this.phone = false;
        this.toilet = false;
        this.comic = false;
        this.bathroomcabinet = false;
        this.kitchencabinet = false;
        this.toolbox = false;
        this.screws = false;
        this.ducttape = false;
        this.harrypotter = false;
        this.sandwich = false;
        this.rug = false;
        this.pills = false;
        this.door = false;
        this.poop = false;
        this.liquor = false;
        this.angrybirds = false;
    }
    
    /*
    - Grabbing of the items available and put into the inventory.
    */
    public void grabWrench() {
        this.wrench = true;
    }
    public void grabHouseKey() {
        this.housekey = true;
    }
    public void grabCabinetKey() {
        this.cabinetkey = true;
    }
    public void grabClips() {
        this.clips = true;
    }
    public void grabNote() {
        this.note = true;
    }
    public void grabPhone() {
        this.phone = true;
    }
    public void openComic() {
        this.comic = true;
    }
    public void openToilet() {
        this.toilet = true;
    }
    public void openKitchenCabinet() {
        this.kitchencabinet = true;
    }
    public void openBathroomCabinet() {
        this.bathroomcabinet = true;
    }
    public void openToolbox() {
        this.toolbox = true;
    }
    public void openHarryPotter() {
        this.harrypotter = true;
    }
    public void grabSandwich() {
        this.sandwich = true;
    }
    public void moveRug() {
        this.rug = true;
    }
    public void grabPills() {
        this.pills = true;
    }
    public void openDoor() {
        this.door = true;
    }
    public void grabLiquor() {
        this.liquor = true;
    }
    public void takePoop() {
        this.poop = true;
    }
    public void grabScrews() {
        this.screws = true;
    }
    public void grabDuctTape() {
        this.ducttape = true;
    }
    public void playAngryBirds() {
        this.angrybirds = true;
    }
    
    /*
    - Checks if player has the given item
    */
    public boolean haveWrench() {
        return this.wrench;
    }
    public boolean haveHouseKey() {
        return this.housekey;
    }
    public boolean haveClips() {
        return this.clips;
    }
    public boolean haveCabKey() {
        return this.cabinetkey;
    }
    public boolean haveNote() {
        return this.note;
    }
    public boolean havePhone() {
        return this.phone;
    }
    public boolean toiletOpened() {
        return this.toilet;
    }
    public boolean comicOpened() {
        return this.comic;
    }
    public boolean kitchenCabinetOpened() {
        return this.kitchencabinet;
    }
    public boolean bathroomCabinetOpened() {
        return this.bathroomcabinet;
    }
    public boolean toolboxOpened() {
        return this.toolbox;
    }
    public boolean harryPotterOpened() {
        return this.harrypotter;
    }
    public boolean sandwichGrabbed() {
        return this.sandwich;
    }
    public boolean rugMoved() {
        return this.rug;
    }
    public boolean pillsGrabbed() {
        return this.pills;
    }
    public boolean doorOpened() {
        return this.door;
    }
    public boolean liquorDrank() {
        return this.liquor;
    }
    public boolean poopTaken() {
        return this.poop;
    }
    public boolean screwsGrabbed() {
        return this.screws;
    }
    public boolean ductTapeGrabbed() {
        return this.ducttape;
    }
    public boolean angryBirdsPlayed() {
        return this.angrybirds;
    }
}
