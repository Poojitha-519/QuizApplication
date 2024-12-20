
public class SkipLifeLine implements LifeLine {
    private boolean available = true;

    @Override
    public boolean isAvailable() { return available; }

    @Override
    public void use() {
        if (available) {
            throw new IllegalStateException("Skip Lifeline already used");
        }
        available = false;
    }

    @Override
    public String getName() { return "Skip"; }
} 


