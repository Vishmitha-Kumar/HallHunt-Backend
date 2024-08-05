package com.security.template.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.security.template.model.Hall;
import com.security.template.model.HallImages;
import com.security.template.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public HallImages addImage(MultipartFile file, Hall hall) throws IOException {
        HallImages hallImage = new HallImages();
        hallImage.setImageName(file.getOriginalFilename());
        hallImage.setData(file.getBytes());
        hallImage.setHalls(hall);

        return imageRepository.save(hallImage);
    }

    public List<HallImages> getImagesByHallId(Long hallId) {
        return imageRepository.findByHalls_Id(hallId);
    }

    // Other methods as needed...
}
