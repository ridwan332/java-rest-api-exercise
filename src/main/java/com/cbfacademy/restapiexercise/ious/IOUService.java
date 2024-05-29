package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
@Service
public class IOUService {

  private final IOURepository iouRepository;

    public IOUService(IOURepository iouRepository) {
    this.iouRepository = iouRepository;
}

    

    /**
     * Retrieve a list of all IOUs.
     *
     * @return A list of all IOUs.
     */
     public List<IOU> getAllIOUs(){
        return iouRepository.findAll();

    }

    /**
     * Retrieve an IOU by its ID.
     *
     * @param id The ID of the IOU to retrieve.
     * @return The IOU with the specified ID, or null if not found.
     */
    IOU getIOU(UUID id) throws NoSuchElementException{
        return iouRepository.findById(id).orElseThrow();
    }

    /**
     * Create a new IOU.
     *
     * @param iou The IOU object to create.
     * @return The created IOU.
     */
    public IOU createIOU(IOU iou) throws IllegalArgumentException{
        if (iou == null) 
        {
            throw new IllegalArgumentException("IOU object cannot be null");
        }

        return iouRepository.save(iou);
        }

    /**
     * Update an existing IOU by its ID.
     *
     * @param id         The ID of the IOU to update.
     * @param updatedIOU The updated IOU object.
     * @return The updated IOU, or null if the ID is not found.
     */
      public IOU updateIOU(UUID id, IOU updatedIOU) throws IllegalArgumentException  {
        if (updatedIOU == null) 
        {
            throw new IllegalArgumentException("Updated IOU object cannot be null");
            
        }
        IOU updatedIou = iouRepository.save(updatedIOU);
        return updatedIou;
        
      }

    /**
     * Delete an IOU by its ID.
     *
     * @param id The ID of the IOU to delete.
     * @return 
     */
     public void deleteIOU(UUID id) throws NoSuchElementException {

        if (iouRepository.findById(id).isPresent())
        {
            iouRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException("id not found");
        }
      
     }

}