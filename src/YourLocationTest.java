import com.team32.TourLocation;
import com.team32.YourLocation;

import junit.framework.TestCase;


public class YourLocationTest extends TestCase {
	
	TourLocation test1;
	TourLocation test2;
	YourLocation random;

	protected void setUp() throws Exception {
		super.setUp();
		test1 = new TourLocation(5,5,"random","pic","history","date", 1);
		test2 = new TourLocation(10,10,"random","pic","history","date", 2);
		random = new YourLocation();
	}

	public void testDistanceFromNextTarget() {
		random.setLatitude(test1.getLatitude());
		random.setLongitude(test1.getLongitude());
		assertEquals(0.0,(random.distanceFromNextTarget(test1)));
		assertEquals(782.7414227228232,(random.distanceFromNextTarget(test2)));
		random.setLatitude(4.999);
		random.setLongitude(4.999);
		assertTrue(1 > random.distanceFromNextTarget(test1));
	}

}
