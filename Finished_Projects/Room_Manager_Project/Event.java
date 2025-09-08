package Finished_Projects.Room_Manager_Project;


/**
 * Write a description of class Event here.
 *
 * @author (James Cox)
 * @version (1.0)
 */
public class Event
{
    private int capacity;
    private int numOfPeople;
    private String eventName;
    private String roomName;
    /**
     * Constructor for objects of class Event
     */
    public Event(String EventName, String RoomName, int Capacity)
    {
        eventName = EventName;
        roomName = RoomName;
        numOfPeople = 0;
        // turns capacity to -1 if capacity is negative. will use this in 
        //getCapacity()
        if( numOfPeople <= Capacity)
        {
            capacity = Capacity;
        }
        else
        {
            capacity = -1;
        }
    }
    
    public String getEventName()
    {
        return eventName;
    }
    
        public String getRoomName()
    {
        return roomName;
    }
    
        public int getCapacity()
    {
        if (capacity >= 0)
        {
            return capacity;
        }
        else
        {
            System.out.println("Room capacity input is too low");
            return capacity;
        }
    }
    
        public int getNumOfPeople()
    {
        return numOfPeople;
    }
    
    public void register()
    {
        if (numOfPeople < capacity)
        {
            numOfPeople ++;
        }
        else
        {
            System.out.println("The room is full.");
        }
    }
    
    public void deregister()
    {
        if (numOfPeople > 0)
        {
            numOfPeople --;
        }
        else
        {
            System.out.println("There are no registerations.");
        }
    }
    
    public void changeRoom(String RoomName, int Capacity)
    {
        if( Capacity >= numOfPeople)
        {
            roomName = RoomName;
            capacity = Capacity;
        }
        else
        {
            System.out.println("Unable to change the room.");
        }
    }
    
    public boolean isSpace(int groupSize)
    {
        if (groupSize < 0)
        {
            return false;
        }
        else if (groupSize <= (capacity - numOfPeople))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void printEventDetails()
    {
        System.out.println(eventName + " in " + roomName +". " 
        + numOfPeople + " registered. Capacity " + capacity + ".");
    }
}
