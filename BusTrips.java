import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;

public class BusTrips {
    private static final int TIME_LIMIT_MINUTES = 120;

    public static void main(String[] args) {
        // Path to folder with files
        String path = "gtfs/";

        ArrayList<StopTimes> stopTimesList = new ArrayList<>();
        ArrayList<Stop> stopsList = new ArrayList<>();
        ArrayList<Route> routesList = new ArrayList<>();
        ArrayList<Trip> tripsList = new ArrayList<>();

        ArrayList<StopTimes> selectedBuses = new ArrayList<>();
        ArrayList<String> selectedRoutes = new ArrayList<>();
        ArrayList<String> selectedTimes = new ArrayList<>();

        boolean stopNameInvalid = true;

        // Check args
        if (args.length != 3) {
            System.err.println("Usage: java BusTrips <bus stop id> <number of next buses> <time relative|absolute>.");
            System.exit(1);
        }

        // Check number args
        try {
            if (Integer.parseInt(args[0]) < 0 || Integer.parseInt(args[1]) < 0) {
                System.err.println("Bus stop id and number of next buses must be positive numbers.");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Check time arg
        if (!args[2].equals("relative") && !args[2].equals("absolute")) {
            System.err.println("Invalid time type. Please use \"relative\" or \"absolute\".");
            System.exit(1);
        }

        // Get current time
        LocalTime currentTime = LocalTime.now();
        // LocalTime currentTime = LocalTime.parse("18:20:00", DateTimeFormatter.ofPattern("HH:mm:ss"));

        // Read data
        try {
            stopTimesList = readStopTimes(path + "stop_times.txt");
            stopsList = readStops(path + "stops.txt");
            routesList = readRoutes(path + "routes.txt");
            tripsList = readTrips(path + "trips.txt");
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
            System.exit(1);
        }

        // Get selected buses
        selectedBuses = getSelectedBuses(stopTimesList, args[0], args[1], currentTime);

        // Print stop name
        for (Stop obj : stopsList) {
            if (obj.getStopId().equals(args[0])) {
                System.out.println(obj.getStopName());
                stopNameInvalid = false;
                break;
            }
        }

        // If stop name is not valid
        if (stopNameInvalid) {
            System.err.println("Bus stop id " + args[0] + " is not valid.");
            System.exit(1);
        }

        // Get names of routes and add arrival times
        for (StopTimes obj : selectedBuses) {
            String routeName = getRouteName(routesList, findRouteId(tripsList, obj.getTripId()));
            if (!selectedRoutes.contains(routeName)) {
                selectedRoutes.add(routeName);
                selectedTimes.add(setTime(obj.getArrivalTime(), currentTime, args[2]));
            } else {
                int id = getRouteIdInArray(selectedRoutes, routeName);
                selectedTimes.set(id,
                        selectedTimes.get(id) + ", " + setTime(obj.getArrivalTime(), currentTime, args[2]));
            }
        }

        // If no arrivals
        if (selectedTimes.isEmpty()) {
            System.out.println("There are not arrivals in the next 2h.");
        }

        // Print routes and arrival times
        for (int i = 0; i < selectedRoutes.size(); i++) {
            System.out.println(selectedRoutes.get(i) + ": " + selectedTimes.get(i));
        }
    }

    private static long getMinuteDiff(LocalTime baseTime, String secondaryTime) {
        LocalTime parsedTime = LocalTime.parse(secondaryTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
        return ChronoUnit.MINUTES.between(baseTime, parsedTime);
    }

    private static String setTime(String arrivalTime, LocalTime currentTime, String type) {
        long minutesDiff = getMinuteDiff(currentTime, arrivalTime);
        if (type.equals("relative")) {
            return minutesDiff + "min";
        } else {
            return arrivalTime;
        }
    }

    public static int getRouteIdInArray(ArrayList<String> routeList, String routeName) {
        for (int i = 0; i < routeList.size(); i++) {
            if (routeList.get(i).equals(routeName)) {
                return i;
            }
        }

        return -1;
    }

    public static String getRouteName(ArrayList<Route> routeList, String routeId) {
        for (Route route : routeList) {
            if (route.getRouteId().equals(routeId)) {
                return route.getRouteShortName();
            }
        }

        return null;
    }

    public static String findRouteId(ArrayList<Trip> tripList, String tripId) {
        for (Trip trip : tripList) {
            if (trip.getTripId().equals(tripId)) {
                return trip.getRouteId();
            }
        }

        return null;
    }

    public static <T> ArrayList<T> readFile(String filePath, Function<String[], T> mapper, int expectedColumns)
            throws IOException {
        ArrayList<T> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                while ((line = br.readLine()) != null) {
                    String[] values = new String[expectedColumns];
                    String[] splitValues = line.split(",");
                    for (int i = 0; i < values.length; i++) {
                        values[i] = (i < splitValues.length) ? splitValues[i] : "";
                    }
                    list.add(mapper.apply(values));
                }
            }
        }

        return list;
    }

    public static ArrayList<StopTimes> readStopTimes(String filePath) throws IOException {
        return readFile(filePath, values -> new StopTimes(values[0], values[1], values[2], values[3], values[4],
                values[5], values[6], values[7], values[8], values[9]), 10);
    }

    public static ArrayList<Stop> readStops(String filePath) throws IOException {
        return readFile(filePath, values -> new Stop(values[0], values[1], values[2], values[3], values[4], values[5],
                values[6], values[7], values[8], values[9], values[10], values[11]), 12);
    }

    public static ArrayList<Route> readRoutes(String filePath) throws IOException {
        return readFile(filePath, values -> new Route(values[0], values[1], values[2], values[3], values[4], values[5],
                values[6], values[7], values[8]), 9);
    }

    public static ArrayList<Trip> readTrips(String filePath) throws IOException {
        return readFile(filePath, values -> new Trip(values[0], values[1], values[2], values[3], values[4], values[5],
                values[6], values[7], values[8], values[9], values[10], values[11], values[12]), 13);
    }

    public static ArrayList<StopTimes> getSelectedBuses(ArrayList<StopTimes> stopTimesList, String busStopId,
            String numberOfBuses, LocalTime currentTime) {
        ArrayList<StopTimes> list = new ArrayList<>();

        // Sort by time
        Collections.sort(stopTimesList);
        int counter = 0;

        for (StopTimes obj : stopTimesList) {
            if (counter == Integer.parseInt(numberOfBuses))
                break;
            long minutesDiff = getMinuteDiff(currentTime, obj.getArrivalTime());
            // Check time diff and bus stop
            if (minutesDiff > 0 && minutesDiff <= TIME_LIMIT_MINUTES && obj.getStopId().equals(busStopId)) {
                list.add(obj);
                counter++;
            }
        }

        return list;
    }
}
