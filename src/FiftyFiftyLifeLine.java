
class FiftyFiftyLifeLine {
    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void use() {
        if (available) {
            available = false;
        } else {
            System.out.println("50-50 lifeline has already been used.");
        }
    }
}
