import com.sun.org.apache.xpath.internal.operations.Gt;

public class Lamp {

    private int capacity;
    private int timesRubbed;
    private int timesRecharged;

    public Lamp(){
        this.capacity=RandomSetter.maxGenieRandomizer();

    }

    public Genie rub(){
        timesRubbed++;
        return genieCreator();

    }

    private Genie genieCreator (){
        if(timesRubbed%2 == 0 && timesRubbed<capacity){
            return new FriendlyGenie();
        }
        else if(timesRubbed%1 == 0 && timesRubbed<capacity){
            return new GrumpyGenie();
        }
        return new RecyclableDemon();
    }

    public void ask4Wish(Genie genie){
        genie.grantWish();

        if (genie instanceof RecyclableDemon){
            rechargeLamp(genie);
        }
    }
    private void rechargeLamp(Genie genie){
        timesRecharged++;
        capacity=RandomSetter.maxGenieRandomizer();
        timesRubbed=0;
    }
    public void lampInfo(){
        System.out.println("Capacity: " + capacity + "\nTimes rubbed: " + timesRubbed + "\nTimes recharged: " + timesRecharged);
    }

}
