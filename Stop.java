public class Stop {
    private String stopId;
    private String stopCode;
    private String stopName;
    private String stopDesc;
    private String stopLat;
    private String stopLon;
    private String zoneId;
    private String stopUrl;
    private String locationType;
    private String parentStation;
    private String stopTimezone;
    private String wheelchairBoarding;

    // Constructor
    public Stop(String stopId, String stopCode, String stopName, String stopDesc, String stopLat, String stopLon,
            String zoneId, String stopUrl, String locationType, String parentStation, String stopTimezone,
            String wheelchairBoarding) {
        this.stopId = stopId;
        this.stopCode = stopCode;
        this.stopName = stopName;
        this.stopDesc = stopDesc;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
        this.zoneId = zoneId;
        this.stopUrl = stopUrl;
        this.locationType = locationType;
        this.parentStation = parentStation;
        this.stopTimezone = stopTimezone;
        this.wheelchairBoarding = wheelchairBoarding;
    }

    // Getter methods
    public String getStopId() {
        return stopId;
    }

    public String getStopCode() {
        return stopCode;
    }

    public String getStopName() {
        return stopName;
    }

    public String getStopDesc() {
        return stopDesc;
    }

    public String getStopLat() {
        return stopLat;
    }

    public String getStopLon() {
        return stopLon;
    }

    public String getZoneId() {
        return zoneId;
    }

    public String getStopUrl() {
        return stopUrl;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getParentStation() {
        return parentStation;
    }

    public String getStopTimezone() {
        return stopTimezone;
    }

    public String getWheelchairBoarding() {
        return wheelchairBoarding;
    }

    // Method to display Stop information
    public void displayInfo() {
        System.out.println("Stop ID: " + stopId);
        System.out.println("Stop Code: " + stopCode);
        System.out.println("Stop Name: " + stopName);
        System.out.println("Stop Description: " + stopDesc);
        System.out.println("Stop Latitude: " + stopLat);
        System.out.println("Stop Longitude: " + stopLon);
        System.out.println("Zone ID: " + zoneId);
        System.out.println("Stop URL: " + stopUrl);
        System.out.println("Location Type: " + locationType);
        System.out.println("Parent Station: " + parentStation);
        System.out.println("Stop Timezone: " + stopTimezone);
        System.out.println("Wheelchair Boarding: " + wheelchairBoarding);
    }
}
