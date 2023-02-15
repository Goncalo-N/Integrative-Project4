package eapli.base.persistence.impl.jpa;

import eapli.base.product.domain.Photo;
import eapli.base.product.repository.PhotoRepository;

public class JpaPhotoRepository  extends BasepaRepositoryBase<Photo, String, String> implements PhotoRepository {

    public JpaPhotoRepository(String persistenceUnitName) {
        super(persistenceUnitName, "code");
    }
}
