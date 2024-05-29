package com.cbfacademy.restapiexercise.ious;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.core.ipc.http.HttpSender.Response;

import org.springframework.lang.Nullable;



@RestController
@RequestMapping("API/ious")
public class IOUController {
  IOUService iouService;
  
  public IOUController(IOUService iouService) {
    this.iouService = iouService;
  }

  @GetMapping
  public List<IOU> getAllIOUs() {
      return iouService.getAllIOUs();
  }
  @GetMapping("/{id}")
  public IOU getId(@PathVariable UUID Id) {
    try{
   return iouService.getIOU(Id);
  }catch(NoSuchElementException e){
    throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
  }
  }
  @PostMapping("iou")
  public IOU postIou(@RequestBody IOU iou) {
     try{
      return iouService.createIOU(iou);
     }catch(IllegalArgumentException e){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
     }
  }
  @PutMapping("{id}")
  public IOU putIou(@PathVariable IOU id, @RequestBody IOU iou) {
     try{
    return iouService.updateIOU(null, iou);
     }catch(IllegalArgumentException  e)
     {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage(),e);
     }
  }
  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteIou(@PathVariable UUID id) {
    try {
      iouService.deleteIOU(id);

      return ResponseEntity.noContent().build();
  } catch (NoSuchElementException exception) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IOU Not Found", exception);
  } catch (RuntimeException exception) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
  }
}
}
