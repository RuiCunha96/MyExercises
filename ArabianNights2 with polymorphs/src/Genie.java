public abstract class Genie {
    private int wishes;
    private int wishesGranted;

    public Genie (){
        this.wishes = RandomSetter.maxWishesRandomizer();
        wishesGranted=wishes;
    }

    public int getWishes() {
        return wishes;
    }

    public int getWishesGranted() {
        return wishesGranted;
    }

    public void decrementWishesGranted() {
        wishesGranted--;
    }

    public abstract Genie grantWish();





}
