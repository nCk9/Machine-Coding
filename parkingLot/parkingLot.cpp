#include <iostream>
#include <vector>
#include <string>

using namespace std;

enum VEHICLE_TYPE{
    CAR, BIKE, TRUCK
};

class vehicle{
    public:
    VEHICLE_TYPE vehicleType;
    string color;
    string regNumber;
};

class parkingSpot{
    public:
    vehicle containsVehicle;
    bool isEmpty;
};

class aFloor{
    public:
    vector<parkingSpot> parkingSpots;
};

class parkingLot{
    public:
    vector<aFloor> floors;
    string parkingLotId;

    parkingLot(string lotId, int numOfFloors, int slotsPerFloor){ //parametrized constructor
        parkingLotId = lotId;
        floors.resize(numOfFloors);
        // for(int i=0; i<numOfFloors; i++)
        // {
        //     floors[i] = new vector<parkingSpot> (slotsPerFloor);

        // }
    }
    string getParkingLotId(){
        return parkingLotId;
    }
};


int main(){
    cout << "Entering the parking lot system.\n";
    string input;
    do{
        cin >> input;
        if(input == "create_parking_lot"){
            string parkingLotId;
            int numFloors;
            int splotsPerFloor;
            cin >> parkingLotId >> numFloors >> splotsPerFloor;

        }


    }while(input != "exit");
}