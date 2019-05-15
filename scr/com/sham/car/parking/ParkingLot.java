package com.sham.car.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParkingLot {
	 
    private static final int NUMBER_OF_SMALL_SLOTS = 10;
    private static final int NUMBER_OF_COMPACT_SLOTS = 10;
    private static final int NUMBER_OF_LARGE_SLOTS = 10;
    public Map<Long, Slot> occupiedSlots;
    private List<Slot> smallSlots;
    private List<Slot> compactSlots;
    private List<Slot> largeSlots;
 
    public ParkingLot() {
        smallSlots = new ArrayList<>(NUMBER_OF_SMALL_SLOTS);
        compactSlots = new ArrayList<>(NUMBER_OF_COMPACT_SLOTS);
        largeSlots = new ArrayList<>(NUMBER_OF_LARGE_SLOTS);
        createSlots();
        occupiedSlots = new HashMap<>();
    }
 
    private void createSlots() {
 
        for (int i = 1; i <= NUMBER_OF_SMALL_SLOTS; i++) {
            smallSlots.add(new SmallSlot(i));
        }
        for (int i = 1; i <= NUMBER_OF_COMPACT_SLOTS; i++) {
            compactSlots.add(new CompactSlot(i));
        }
        for (int i = 1; i <= NUMBER_OF_LARGE_SLOTS; i++) {
            largeSlots.add(new LargeSlot(i));
        }
     }
 
    public long park(Vehicle vehicle) {
 
        Slot slot;
        long uniqueToken = -1;
 
        if (vehicle.getVehicleType() == VehicleType.BIKE) {
            if ((slot = getFirstEmptySlot(smallSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            } else if ((slot = getFirstEmptySlot(compactSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            } else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        } else if (vehicle.getVehicleType() == VehicleType.CAR) {
            if ((slot = getFirstEmptySlot(compactSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            } else if ((slot = getFirstEmptySlot(largeSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        } else {
            if ((slot = getFirstEmptySlot(largeSlots)) != null) {
                uniqueToken = parkHelper(slot, vehicle);
            }
        }
        return uniqueToken;
    }
 
    public void unPark(long uniqueToken) {
        occupiedSlots.get(uniqueToken).unPark();
        occupiedSlots.remove(uniqueToken);
    }
 
    private Slot getFirstEmptySlot(List<Slot> slots) {
        Iterator<Slot> slotIterator = slots.iterator();
        Slot emptySlot = null;
         while (slotIterator.hasNext()) {
            emptySlot = slotIterator.next();
            if (!emptySlot.isOccupied()) {
                break;
            }
        }
        return emptySlot;
    }
 
    private long parkHelper(Slot slot, Vehicle vehicle) {
        slot.park();
        long uniqueToken = vehicle.hashCode() * 43;
        occupiedSlots.put(uniqueToken, slot);
        return uniqueToken;
    }
}