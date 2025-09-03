import java.util.*;
/**
 * Keep track of multiple assistants.
 * @author James Cox
 * @version your-date-or-version
 */
public class AssistantCentre
{
    private ArrayList<Assistant> assistants;
    /**
     * Create a AssistantCentre object.
     */
    public AssistantCentre()
    {
        assistants = new ArrayList<Assistant>(); //initialises array of 
    }                                            //assistants
    
    /**
     * Add a new assistant to the collection.
     * @param assistant The assistant.
     */
    public void addAssistant(Assistant assistant)
    {
        assistants.add(assistant); //adds an assistant to the assistants 
    }                              //array
    
    /**
     * Get the number of assistants.
     * @return the number of assistants in the collection.
     */
    public int getNumberOfAssistants()
    {
        return assistants.size() + 1; //amount of items in array
    }                                 //is the size of array + 1
    
    /**
     * Get the number of assistants in the given location.
     * @param location The location of the assistants.
     * @return the number of assistants in the collection
     *         who in the given location.
     */
    public int getNumberOfAssistants(int location)
    {
        int count = 0;
        for(Assistant assistant : assistants){
            if(assistant.getLocation() == location){
                count++; //adds to count if the assistants location
            }            //equals the inputted equation
        }
        return count;
    }
    
        
    
    /**
     * List all of the assistants, one per line.
     * This uses the Assistant objects’ getDetails
     * method to format the details.
     */
    public void list()
    {
        int identity;
        int location;//initialises variables to change for each assistant
        boolean available;
        for(Assistant assistant : assistants){
            identity = assistant.getIdentity();
            location = assistant.getLocation();// changes variables for 
            available = assistant.isAvailable();//current assistant
            System.out.println("Identity - " + identity);
            System.out.println("Location - " + location);//prints variables
            System.out.println("Available - " + available);
        }
    }
    
    /**
     * Set the availability of the assistant whose identity is given.
     * @param id The assistant's identity.
     * @param location The assistant's new location.
     * @param available Whether they are now available or not.
     */
    public void setAvailability(int identity, int location, boolean available)
    {
      for(Assistant assistant : assistants){
          if(identity == assistant.getIdentity()){ //finds assistant
              assistant.moveTo(location); //changes location of assistant
            if(available == true){
                  assistant.setAvailable(); //changes availability
              }
              else{
                  assistant.setOccupied();  //changes availability
              }
          }
      }
    }
    
    /**
     * Remove the assistant with the given identity.
     * @param day The id of the assistant to be removed.
     * @return true if an assistant was found and removed,
     *         false otherwise.
     */
    public boolean removeAssistant(int identity)
    {
        boolean found = false;
        int index = 0;
        for(Assistant assistant : assistants){
            if(identity ==  assistant.getIdentity()){
                assistants.remove(index);
                found = true;
                index++; //removes assistant from the array is its the 
            }            //right one
            else{
               index++; 
            }
        }
        return found;
    }
    
    /**
     * Find the nearest available assistant to the given location.
     * Distance is measured by the absolute value of the
     * difference between two locations.
     * For instance, the distance between locations 1 and 5 is 4,
     * and the distance between locations 6 and 4 is 2.
     * If more than one assistant is available and nearest to the given
     * location then the one with the lowest identity must be returned.
     * @param location Look for the assistant nearest to this location.
     * @return the nearest assistant, or null if there are no available assistants.
     */
    public Assistant findNearestAvailable(int location)
    {
        int identity;
        int currentLocation;
        int distance = 0;
        int index = 0;
        Assistant nearestAssistant = assistants.get(0);
        boolean found = false;
        for(Assistant assistant : assistants){
            if(assistant.isAvailable() == true){
                if(location == assistant.getLocation()){
                    nearestAssistant = assistants.get(index);
                    found = true;
                }
                else{
                    distance++;
                }
                if(distance>0){
                    nearestAssistant = assistants.get(index);
                    found = true;
                }
                index++;
            }
            else{
                found = false;
                nearestAssistant = assistants.get(0);
            }
        }
        if(found == true){
            return nearestAssistant;
        }
        else{
            return null;
        }
    }
}
