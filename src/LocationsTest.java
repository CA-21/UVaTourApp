import com.team32.Locations;

import junit.framework.TestCase;


public class LocationsTest extends TestCase {
	
	Locations test;

	protected void setUp() throws Exception {
		super.setUp();
		test = new Locations();
	}

	public void testLoadData() {
		assertNotNull(test.getLocations());
		test.loadData();
		assertEquals(10 , test.getLocations().size());
		assertEquals("Amphitheater",test.getLocations().get(5).getName());
	}

}
