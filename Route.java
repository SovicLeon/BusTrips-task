public class Route {
    private String routeId;
    private String agencyId;
    private String routeShortName;
    private String routeLongName;
    private String routeDesc;
    private String routeType;
    private String routeUrl;
    private String routeColor;
    private String routeTextColor;

    // Constructor
    public Route(String routeId, String agencyId, String routeShortName, String routeLongName, String routeDesc,
                 String routeType, String routeUrl, String routeColor, String routeTextColor) {
        this.routeId = routeId;
        this.agencyId = agencyId;
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeDesc = routeDesc;
        this.routeType = routeType;
        this.routeUrl = routeUrl;
        this.routeColor = routeColor;
        this.routeTextColor = routeTextColor;
    }

    // Getter methods
    public String getRouteId() {
        return routeId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public String getRouteType() {
        return routeType;
    }

    public String getRouteUrl() {
        return routeUrl;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

    // Method to display Route information
    public void displayInfo() {
        System.out.println("Route ID: " + routeId);
        System.out.println("Agency ID: " + agencyId);
        System.out.println("Route Short Name: " + routeShortName);
        System.out.println("Route Long Name: " + routeLongName);
        System.out.println("Route Description: " + routeDesc);
        System.out.println("Route Type: " + routeType);
        System.out.println("Route URL: " + routeUrl);
        System.out.println("Route Color: " + routeColor);
        System.out.println("Route Text Color: " + routeTextColor);
    }
}
