## This Java program shows upcoming bus arrivals for a specified stop, displaying the number of requested buses within 2 hours.

Uses GTFS Schedule for the data.

Developed with Java version "22.0.1" 2024-04-16.

### usage: cmd> java BusTrips <**bus stop ID**> <**number of buses**> <time (relative|absolute)>

---

Example use, current time: "09:54:00":

cmd> java BusTrips.java 2 5 absolute

AL Masjid Al-nabawi (Clock Roundabout)

106: 09:56:45

101: 09:58:59, 10:08:56

107: 10:01:54, 10:10:00

---

Example use, current time: "09:54:00":

cmd> java BusTrips.java 2 5 relative

AL Masjid Al-nabawi (Clock Roundabout)

106: 2min

101: 4min, 14min

107: 7min, 15min
