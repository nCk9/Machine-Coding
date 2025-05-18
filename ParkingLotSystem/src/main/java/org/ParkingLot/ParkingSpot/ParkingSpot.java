package org.ParkingLot.ParkingSpot;

public class ParkingSpot {
    private ParkingSpotType spotType;
    private ParkingSpotStatus parkingSpotStatus;
    private Integer parkingSpotId;

    public ParkingSpot(){
        spotType = ParkingSpotType.FOUR_WHEELER;
        parkingSpotStatus = ParkingSpotStatus.AVAILABLE;
        parkingSpotId = null;
    }

   public  void setParkingSpotStatus(ParkingSpotStatus status){
        parkingSpotStatus = status;
    }

    public ParkingSpotStatus getParkingSpotStatus(){
        return parkingSpotStatus;
    }

    public void setParkingSpotId(Integer spotId){
        parkingSpotId = spotId;
    }

    public Integer getParkingSpotId() {
        return parkingSpotId;
    }
}
