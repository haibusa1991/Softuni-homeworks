package L08IteratorsAndComparators.E08PetClinics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic {
    private final String name;
    private final int capacity;
    private Room midRoom = null;

    public Clinic(String name, int capacity) {
        if (capacity % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.capacity = capacity;
        initializeRooms();
        this.name = name;
    }

    private class Room {
        private Pet pet = null;
        private Room prev = null;
        private Room next = null;
        private int roomNo;

        public boolean isEmpty() {
            return pet == null;
        }

        public void add(Pet pet) {
            this.pet = pet;
        }

        @Override
        public String toString() {
            return pet == null
                    ? "Room empty"
                    : pet.toString();
        }
    }

    private class AddIterator implements Iterator<Room> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < capacity;
        }

        @Override
        public Room next() {
            Room currentRoom = midRoom;
            if (index == 0) {
                index++;
                return midRoom;
            }

            if (index % 2 == 0) {//has to return right room
                for (int i = 0; i < index / 2; i++) {
                    currentRoom = currentRoom.next;
                }
                index++;
                return currentRoom;
            }
            for (int i = 0; i < (index / 2) + 1; i++) {
                currentRoom = currentRoom.prev;
            }
            index++;
            return currentRoom;
        }
    }

    private class ReleaseIterator implements Iterator<Room> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < capacity;
        }

        @Override
        public Room next() {
            if (index == 0) {
                index++;
                return midRoom;
            }
            Room currentRoom = midRoom;
            for (int i = 0; i < index; i++) {
                if (currentRoom.next != null) {
                    currentRoom = currentRoom.next;
                } else {
                    currentRoom = getLeftmostRoom();
                }
            }
            index++;
            return currentRoom;
        }
    }

    private Room getLeftmostRoom() {
        Room currentRoom = midRoom;
        for (int i = 0; i < capacity / 2; i++) {
            currentRoom = currentRoom.prev;
        }
        return currentRoom;
    }

    private void initializeRooms() {
        midRoom = new Room();
        if (capacity > 1) {
            Room leftRoom = new Room();
            Room rightRoom = new Room();
            midRoom.prev = leftRoom;
            leftRoom.next = midRoom;
            midRoom.next = rightRoom;
            rightRoom.prev = midRoom;
            for (int i = 1; i < capacity / 2; i++) {
                Room newLeftRoom = new Room();
                leftRoom.prev = newLeftRoom;
                newLeftRoom.next = leftRoom;
                leftRoom = newLeftRoom;

                Room newRightRoom = new Room();
                rightRoom.next = newRightRoom;
                newRightRoom.prev = rightRoom;
                rightRoom = newRightRoom;
            }
        }
        addRoomNumbers();
    }

    private void addRoomNumbers() {
        int roomNo = 1;
        Room currentRoom = getLeftmostRoom();
        for (int i = 0; i < capacity; i++) {
            currentRoom.roomNo = roomNo++;
            currentRoom = currentRoom.next;
        }
    }

    public String getName() {
        return name;
    }

    public boolean add(Pet pet) {
        AddIterator roomIterator = new AddIterator();

        Room currentRoom;
        while (roomIterator.hasNext()) {
            currentRoom = roomIterator.next();
            if (currentRoom.isEmpty()) {
                currentRoom.add(pet);
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        ReleaseIterator roomIterator = new ReleaseIterator();
        Room currentRoom;
        while (roomIterator.hasNext()) {
            currentRoom = roomIterator.next();
            if (!currentRoom.isEmpty()) {
                currentRoom.pet = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        AddIterator roomIterator = new AddIterator();
        Room currentRoom;
        while (roomIterator.hasNext()) {
            currentRoom = roomIterator.next();
            if (currentRoom.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        List<Room> printList = new ArrayList<>();
        Room currentRoom = getLeftmostRoom();
        for (int i = 0; i < capacity; i++) {
            printList.add(currentRoom);
            currentRoom = currentRoom.next;
        }
        printList.forEach(System.out::println);
    }

    public void print(int roomNo) {
        Room currentRoom = getLeftmostRoom();
        for (int i = 0; i < capacity; i++) {
            if (currentRoom.roomNo == roomNo) {
                break;
            }
            currentRoom = currentRoom.next;
        }
        System.out.println(currentRoom);
    }
}
