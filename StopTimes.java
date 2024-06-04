import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StopTimes implements Comparable<StopTimes> {
    private String tripId;
    private String arrivalTime;
    private String departureTime;
    private String stopId;
    private String stopSequence;
    private String stopHeadsign;
    private String pickupType;
    private String dropOffType;
    private String shapeDistTraveled;
    private String timepoint;

    // Constructor
    public StopTimes(String tripId, String arrivalTime, String departureTime, String stopId, String stopSequence,
            String stopHeadsign, String pickupType, String dropOffType, String shapeDistTraveled, String timepoint) {
        this.tripId = tripId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
        this.stopHeadsign = stopHeadsign;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
        this.shapeDistTraveled = shapeDistTraveled;
        this.timepoint = timepoint;
    }

    // Getter and Setter methods
    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopSequence() {
        return stopSequence;
    }

    public void setStopSequence(String stopSequence) {
        this.stopSequence = stopSequence;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }

    public void setStopHeadsign(String stopHeadsign) {
        this.stopHeadsign = stopHeadsign;
    }

    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    public String getDropOffType() {
        return dropOffType;
    }

    public void setDropOffType(String dropOffType) {
        this.dropOffType = dropOffType;
    }

    public String getShapeDistTraveled() {
        return shapeDistTraveled;
    }

    public void setShapeDistTraveled(String shapeDistTraveled) {
        this.shapeDistTraveled = shapeDistTraveled;
    }

    public String getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(String timepoint) {
        this.timepoint = timepoint;
    }

    // Method to display StopTimes information
    public void displayInfo() {
        System.out.println("Trip ID: " + tripId);
        System.out.println("Arrival Time: " + arrivalTime);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Stop ID: " + stopId);
        System.out.println("Stop Sequence: " + stopSequence);
        System.out.println("Stop Headsign: " + stopHeadsign);
        System.out.println("Pickup Type: " + pickupType);
        System.out.println("Drop Off Type: " + dropOffType);
        System.out.println("Shape Distance Traveled: " + shapeDistTraveled);
        System.out.println("Timepoint: " + timepoint);
    }

    @Override
    public int compareTo(StopTimes other) {
        // Parse the arrival times of both objects
        LocalTime parsedTimeThis = LocalTime.parse(this.getArrivalTime(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime parsedTimeOther = LocalTime.parse(other.getArrivalTime(), DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Compare the parsed arrival times
        return parsedTimeThis.compareTo(parsedTimeOther);
    }
}
