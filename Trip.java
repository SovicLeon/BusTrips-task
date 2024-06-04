public class Trip {
    private String routeId;
    private String serviceId;
    private String tripId;
    private String tripHeadsign;
    private String tripShortName;
    private String directionId;
    private String blockId;
    private String shapeId;
    private String wheelchairAccessible;
    private String bikesAllowed;
    private String duty;
    private String dutySequenceNumber;
    private String runSequenceNumber;

    // Constructor
    public Trip(String routeId, String serviceId, String tripId, String tripHeadsign, String tripShortName,
            String directionId, String blockId, String shapeId, String wheelchairAccessible, String bikesAllowed,
            String duty, String dutySequenceNumber, String runSequenceNumber) {
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
        this.tripShortName = tripShortName;
        this.directionId = directionId;
        this.blockId = blockId;
        this.shapeId = shapeId;
        this.wheelchairAccessible = wheelchairAccessible;
        this.bikesAllowed = bikesAllowed;
        this.duty = duty;
        this.dutySequenceNumber = dutySequenceNumber;
        this.runSequenceNumber = runSequenceNumber;
    }

    // Getter methods
    public String getRouteId() {
        return routeId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getTripId() {
        return tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public String getDirectionId() {
        return directionId;
    }

    public String getBlockId() {
        return blockId;
    }

    public String getShapeId() {
        return shapeId;
    }

    public String getWheelchairAccessible() {
        return wheelchairAccessible;
    }

    public String getBikesAllowed() {
        return bikesAllowed;
    }

    public String getDuty() {
        return duty;
    }

    public String getDutySequenceNumber() {
        return dutySequenceNumber;
    }

    public String getRunSequenceNumber() {
        return runSequenceNumber;
    }

    // Method to display Trip information
    public void displayInfo() {
        System.out.println("Route ID: " + routeId);
        System.out.println("Service ID: " + serviceId);
        System.out.println("Trip ID: " + tripId);
        System.out.println("Trip Headsign: " + tripHeadsign);
        System.out.println("Trip Short Name: " + tripShortName);
        System.out.println("Direction ID: " + directionId);
        System.out.println("Block ID: " + blockId);
        System.out.println("Shape ID: " + shapeId);
        System.out.println("Wheelchair Accessible: " + wheelchairAccessible);
        System.out.println("Bikes Allowed: " + bikesAllowed);
        System.out.println("Duty: " + duty);
        System.out.println("Duty Sequence Number: " + dutySequenceNumber);
        System.out.println("Run Sequence Number: " + runSequenceNumber);
    }
}
