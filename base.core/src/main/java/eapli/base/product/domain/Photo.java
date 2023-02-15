package eapli.base.product.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Photo implements ValueObject, AggregateRoot<String> {

    @Id
    private String photoPath;

    public Photo() {
    }

    public Photo(String photoPath){
        this.photoPath=photoPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return getPhotoPath().equals(photo.getPhotoPath());
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoPath='" + photoPath + '\'' +
                '}';
    }

    @Override
    public String identity() {
        return null;
    }
}
