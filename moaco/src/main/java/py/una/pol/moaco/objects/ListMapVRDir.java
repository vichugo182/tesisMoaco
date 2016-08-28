package py.una.pol.moaco.objects;

import java.util.ArrayList;
import java.util.List;

public class ListMapVRDir {
	List<MapVRDir> mapRequest;
	
	public ListMapVRDir(){
		this.mapRequest = new ArrayList<MapVRDir>();
	}

	public List<MapVRDir> getMapRequest() {
		return mapRequest;
	}

	public void setMapRequest(List<MapVRDir> mapRequest) {
		this.mapRequest = mapRequest;
	}
	
}
