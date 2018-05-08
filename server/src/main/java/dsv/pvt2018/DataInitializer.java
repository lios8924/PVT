package dsv.pvt2018;

import dsv.pvt2018.lamp.Lamp;
import dsv.pvt2018.lamp.LampService;
import dsv.pvt2018.map.MapCTF;
import dsv.pvt2018.map.MapService;

public class DataInitializer {
	
	public static void initializeData(){
		MapCTF map1 = new MapCTF("Map 1");
		MapCTF map2 = new MapCTF("Map 2");
		MapCTF map3 = new MapCTF("Map 3");
		MapCTF map4 = new MapCTF("Map 4");
		
		Lamp lamp1 = new Lamp(59.407979, 17.945867);
		Lamp lamp2 = new Lamp(59.406722, 17.942627);
		Lamp lamp3 = new Lamp(59.410099, 17.941377);
		Lamp lamp4 = new Lamp(59.407732, 17.947039);
		
		lamp1.setMap(map1);
		lamp2.setMap(map1);
		lamp3.setMap(map2);
		lamp4.setMap(map3);
		
		LampService lampService = new LampService();
		MapService mapService = new MapService();
		
//		lampService.addLamp(lamp1);
//		lampService.addLamp(lamp2);
//		lampService.addLamp(lamp3);
//		lampService.addLamp(lamp4);
		
		mapService.addMap(map1);
		mapService.addMap(map2);
		mapService.addMap(map3);
		mapService.addMap(map4);
		
	}
	
}
