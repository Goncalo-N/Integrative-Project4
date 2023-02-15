package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.product.application.RegisterProductController;
import eapli.base.product.domain.Location;
import eapli.base.product.domain.Photo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class ProductBootstrapper {

    private static final Logger LOGGER = LogManager.getLogger(ProductBootstrapper.class);

    public boolean execute() {
        register("123ABC","A343FSD",12345,"Contintente","343FD4GF","Lenços",
                "Lenços de Papel de cozinha","Caixa de Lenços de Papel", Collections.singletonList(new Photo("photo1.png")),
                "Utensílios de Cozinha", 1.0, 1.5,new Location(1,1,1));

        register("145FGD","3434FDF",14243,"Coca-Cola","654VSDFS3","Lata",
                "Lata de coca-cola zero","Lata de alumínio de coca-cola", Collections.singletonList(new Photo("photo2.png")),
                "Bebida", 0.7, 1.2,new Location(2,1,3));

        register("764GFG","RTRW452",86323,"Logitech","452FDF4DF","Rato",
                "Rato gaming da logitech","Rato preto gaming", Collections.singletonList(new Photo("photo3.png")),
                "Acessório de computadores", 40.3, 45.7,new Location(3,5,1));
        return true;
    }

    private void register(String internalCode, String productionCode, int barCode, String brandName, String reference, String productShortDescription,
                          String productExtendedDescription, String productTechnicalDescription, List<Photo> photoPath,
                          String productCategory, double priceNoTaxes, double priceTaxes, Location location) {

        final RegisterProductController controller = new RegisterProductController();

        try {
            controller.registerNewProduct(internalCode, productionCode, barCode, brandName, reference, productShortDescription, productExtendedDescription, productTechnicalDescription,
                    photoPath, productCategory, priceNoTaxes, priceTaxes, location);
        } catch (Exception exc) {
            System.out.println("------------------------------------------------------------------------------");
            exc.printStackTrace();
            LOGGER.warn("Assuming {} already exists (activate trace log for details)");
            LOGGER.trace("Assuming existing record", exc);
        }
    }
}
