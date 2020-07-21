package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDataBuild {
    public AddPlace addPlacePayload(List<Map<String, String>> list) {
        int accuracy = Integer.parseInt(list.get(0).get("accuracy"));
        String address = list.get(0).get("address");
        String language = list.get(0).get("language");
        String phoneNumber = list.get(0).get("phoneNumber");
        String website = list.get(0).get("website");
        String name = list.get(0).get("name");
        Double latitude = Double.parseDouble(list.get(0).get("latitude"));
        Double longitude = Double.parseDouble(list.get(0).get("longitude"));

        AddPlace p = new AddPlace();
        p.setAccuracy(accuracy);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number(phoneNumber);
        p.setWebsite(website);
        p.setName(name);
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        Location l =new Location();
        l.setLat(latitude);
        l.setLng(longitude);
        p.setLocation(l);

        return p;
    }
}
