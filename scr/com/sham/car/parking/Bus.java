package com.sham.car.parking;

enum VehicleType{
	BIKE, CAR, BUS;
}

abstract class Vehicle {
	VehicleType vihicleType = null;
	public VehicleType getVehicleType(){
		return vihicleType;
	}
	
}
	
class Motorcycle extends Vehicle{
	public Motorcycle(){
		vihicleType = VehicleType.BIKE;
	}
}
	
class Car extends Vehicle {
	public Car(){
		vihicleType = VehicleType.CAR;
	}
}
class Bus extends Vehicle {
	Bus(){
		vihicleType = VehicleType.BUS;
	}
}


abstract class Slot {
    
    private boolean isOccupied;    
    private int slotNumber;
    private VehicleType vihicleType;
     
     
    Slot(int slotNumber, VehicleType vehicleType) {
        isOccupied = false;
        this.slotNumber = slotNumber;
        this.vihicleType = vihicleType;
    }
     
    public VehicleType getVihicleType() {
		return vihicleType;
	}

	public void setVihicleType(VehicleType vihicleType) {
		this.vihicleType = vihicleType;
	}

	boolean isOccupied() {
        return isOccupied;
    }
     
    int getSlotNumber() {
        return slotNumber;
    }
     
    void park() {
        isOccupied = true;
    } 
     
    void unPark() {
       isOccupied = false;
    }
     
    @Override
    public boolean equals(Object o) {
        return (((Slot) o).slotNumber == this.slotNumber);
    }
 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.slotNumber;
        return hash;
    }  
}

class SmallSlot extends Slot {
    
    SmallSlot(int slotNumber){
        super(slotNumber, VehicleType.BIKE);
    }
}
	
class CompactSlot extends Slot {
     
    CompactSlot(int slotNumber) {
        super(slotNumber, VehicleType.CAR);
    }
}

class LargeSlot extends Slot {
 
    LargeSlot(int slotNumber)  {
        super(slotNumber, VehicleType.BUS);
    } 
}