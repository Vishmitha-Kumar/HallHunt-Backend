package com.security.template.model;

import jakarta.persistence.*;

@Entity
public class HallImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageID;

    private String imageName;

    @Lob
    @Column(length = 16777215)
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall halls;

    public HallImages() {
    }

    public HallImages(Long imageID, String imageName, byte[] data, Hall halls) {
        this.imageID = imageID;
        this.imageName = imageName;
        this.data = data;
        this.halls = halls;
    }

    public Long getImageID() {
        return imageID;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Hall getHalls() {
        return halls;
    }

    public void setHalls(Hall halls) {
        this.halls = halls;
    }

   

    // Getters and setters
    // ...
}
