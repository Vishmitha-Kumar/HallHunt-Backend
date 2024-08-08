//package com.security.template.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import com.security.template.model.Hall;
//import com.security.template.model.HallImages;
//import com.security.template.service.HallService;
//import com.security.template.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//
//
//@RestController
//@RequestMapping("/images")
//public class ImageController {
//
//    @Autowired
//    private ImageService imageService;
//
//    @Autowired
//    private HallService hallService;
//
//    @PostMapping("/upload/{hallId}")
//    public HallImages uploadImage(@RequestParam("file") MultipartFile file, @PathVariable Long hallId) throws IOException {
//        Hall hall = hallService.getHallById(hallId);
//        return imageService.addImage(file, hall);
//    }
//
//    @GetMapping("/hall/{hallId}")
//    public List<HallImages> getImagesByHallId(@PathVariable Long hallId) {
//        return imageService.getImagesByHallId(hallId);
//    }
//
//    // Other endpoints as needed...
//}
