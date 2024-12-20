
public class Rewards {
	 private static int totalRewards = 0; 

	    public static void addRewards(int points) {
	        totalRewards += points; 
	    }

	    public static int getTotalRewards() {
	        return totalRewards;
	    }
	}


