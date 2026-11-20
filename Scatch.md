to design a parking lot:

1. There would be a parking spot class, which will contain the vehicle (another class).
2. When a vehicle arrives, it would be assigned a parking receit (another class) which represents the relationship between vehicle and the parking spot.
3. when a vehicle arrives, will you search for the next nearest parking spot which is empty?

class parkingSpot:
    parkingSpotId;
    spotX;
    spotY;
    isOccupied;

class receit:
    receitId;
    parkingSpotId;
    vehicleId; //or vehicleRegNo
    arrivalTime;
    departureTime;
    totalPrice;

class Vechicle (or interface):
    vechicleNo;
    vechicleType; (could be enum)

class ParkingLot:
    2d array of parkingSpots


    
application prompt: we're fetching nearest parkingSpot for you, pls wait!
    --returns parkingSpot co-ordinates
application prompt: please proceed to this (x, y) for pakring, here's is youre receit
    --displays receit

