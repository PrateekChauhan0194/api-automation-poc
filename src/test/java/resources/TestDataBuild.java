package resources;

import pojo.AccountNmiLookup;
import pojo.AddPlace;
import pojo.Location;
import pojo.PostcodeLookup;

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


    public PostcodeLookup postcodeLookupPayload(List<Map<String, String>> list) {
        PostcodeLookup lookupData = new PostcodeLookup();

        String customerType = list.get(0).get("customerType");
        int postcode = Integer.parseInt(list.get(0).get("postcode"));

        lookupData.setCustomerType(customerType);
        lookupData.setPostcode(postcode);

        return lookupData;
    }

    public AccountNmiLookup accountNmiLookupPayload(List<Map<String, String>> list) {
        AccountNmiLookup lookupData = new AccountNmiLookup();

        String customerType = list.get(0).get("customerType");
        String postcode = list.get(0).get("postcode");
        String nmi = list.get(0).get("nmi");
        Boolean addCurrentPlan = Boolean.parseBoolean(list.get(0).get("addCurrentPlan"));
        String electricityAccountNumber = list.get(0).get("electricityAccountNumber");
        String qualifications = list.get(0).get("qualifications");

        lookupData.setCustomerType(customerType);
        lookupData.setPostcode(postcode);
        lookupData.setNmi(nmi);
        lookupData.setAddCurrentPlan(addCurrentPlan);
        lookupData.setElectricityAccountNumber(electricityAccountNumber);

        List<String> myList = new ArrayList<String>();
        myList.add(qualifications);
        lookupData.setQualifications(myList);

        return lookupData;
    }
}
