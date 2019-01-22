import java.time.LocalDate;

/**
 * each event on the list would be added as a LocalEvent
 * @author abigail
 */
public class LocalEvent {
    
    //description of the event
    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * 
     * @param description the description of the event
     */
    public LocalEvent(String description){
        this.setDescription(description);
    }
    
    /**
     * Override toString methods to print out a string description of the event
     * @return the description of the event
     */
    @Override
    public String toString(){
        return getDescription();
    }
    
}


