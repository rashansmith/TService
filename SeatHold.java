import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class SeatHold implements TicketService {
	
	Level Orchestra = new Level(1, 100,25, 50);
	Level Main = new Level(2, 75, 20, 100 );
	Level Balcony1 = new Level(3, 50, 15, 100);
	Level Balcony2 = new Level(4, 40, 15, 100);
	
	
	public Level getLevel(int num) {
		Level levelName = null;
		if (num == 1)
			levelName =  Orchestra;
		if (num == 2)
			levelName =  Main;
		if (num == 3)
			levelName = Balcony1;
		if (num == 4)
			levelName = Balcony2;
		return levelName;
	}
	
	public String ConfirmationCodeGenerator() {
		StringBuilder code = new StringBuilder();
	    Random random = new Random();
		String randomChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		randomChars.charAt(random.nextInt(randomChars.length()));
		 
	    for (int i = 0; i < 7; i++) {
	        code.append(randomChars.charAt(random.nextInt(randomChars
	                .length())));
	    }
	    return code.toString();
	}
	
	
	@Override
	public int numSeatsAvailable(Optional<Integer> venueLevel) {
		int result = 0;
		if (venueLevel.get() == 1) 
			result =  Orchestra.getTotalSeats();
			
		if (venueLevel.get() == 2) 
				result = Main.getTotalSeats();
		
		if (venueLevel.get() == 3)
			result = Balcony1.getTotalSeats();
		
		if (venueLevel.get() == 4) 
			result = Balcony2.getTotalSeats();
		
		return result;	
	}

	@Override
	public String findAndHoldSeats(int numSeats, Optional<Integer> minLevel, Optional<Integer> maxLevel,
			String customerEmail) {
		
		int level = minLevel.get();
		
		// Used to keep track of which levels are used and 
		// how many seats from each level
		ArrayList<Integer> levelSeating = new ArrayList<Integer>();
		ArrayList<Integer> numLevelSeating = new ArrayList<Integer>();
		
		// Calculate levels to look through
		int levelsToSearch = maxLevel.get() - minLevel.get() + 1;
		
		// Start at min level, look through to max level
		// If number of seats needed found before reaching maxlevel, then stop
		// Else continue through other levels until number of seats is met
		while(levelsToSearch != minLevel.get()) {
			Level curr_Level = getLevel(maxLevel.get());
			if (curr_Level.getTotalSeats() >= numSeats) {
				curr_Level.setTotalSeats(curr_Level.getTotalSeats() - numSeats);
				levelSeating.add(curr_Level.getName());
				numLevelSeating.add(numSeats);
				break;
			}
			
			// If there are not enough seats in a level, add that level to the lists
			// and keep checking the other levels until the number of seats needed
			// are satisfied
			if(curr_Level.getTotalSeats() < numSeats) {
				int remainingSeats =  numSeats - curr_Level.getTotalSeats();
				curr_Level.setTotalSeats(curr_Level.getTotalSeats());
				levelSeating.add(curr_Level.getName());
				numLevelSeating.add(curr_Level.getTotalSeats());
				levelsToSearch++;
			}	
				
			}
			return ConfirmationCodeGenerator();
		}
		


	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		return null;
	}

	
}
