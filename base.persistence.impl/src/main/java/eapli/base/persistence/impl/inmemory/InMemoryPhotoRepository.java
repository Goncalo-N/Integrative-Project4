package eapli.base.persistence.impl.inmemory;

import eapli.base.product.domain.Photo;
import eapli.base.product.repository.PhotoRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryPhotoRepository extends InMemoryDomainRepository<Photo, String> implements PhotoRepository {

    static {
        InMemoryInitializer.init();
    }
}
