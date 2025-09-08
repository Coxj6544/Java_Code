

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
        return assistants.size(); //amount of items in array
    }                                 //is the size of array
    
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
        for(Assistant assistant : assistants){
            assistant.getDetails();
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
            if(available){
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
        for(Assistant assistant : assistants){
            if(identity ==  assistant.getIdentity()){
                assistants.remove(assistant);
                return true;
            }            
        }
        return false;
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
        ArrayList<Assistant> available = new ArrayList<>();

        for(Assistant assistant : assistants){
            if(assistant.isAvailable()){
                available.add(assistant);
            }
        }

        if(available.isEmpty()){
            return null;
        }

        int minDistance = Integer.MAX_VALUE;

        for(Assistant assistant : available){
            int currentDistance = Math.abs(assistant.getLocation() - location);
            if(currentDistance < minDistance){
                minDistance = currentDistance;
            }
        }

        for(Assistant assistant : available){
            if((Math.abs(assistant.getLocation() - location) > minDistance)){
                available.remove(assistant);
            }
        }

        int minIdentity = Integer.MAX_VALUE;
        Assistant minAssistant = null;

        for(Assistant assistant : available){
            if(assistant.getIdentity() < minIdentity){
                minIdentity = assistant.getIdentity();
                minAssistant = assistant;
            }
        }
        return minAssistant;


    }
}
