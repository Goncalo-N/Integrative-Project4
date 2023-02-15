package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Photo;
import eapli.base.product.repository.PhotoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhotoBootstrapper {
    private static final Logger LOGGER = LogManager.getLogger(PhotoBootstrapper.class);

    public boolean execute() {
        register("photo1.png");
        register("photo2.png");
        register("photo3.png");
        return true;
    }

    private void register(String photoPath) {

        try {
            PhotoRepository repository = PersistenceContext.repositories().photoRepository();

            final Photo newPhoto = new Photo(photoPath);

            repository.save(newPhoto);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
