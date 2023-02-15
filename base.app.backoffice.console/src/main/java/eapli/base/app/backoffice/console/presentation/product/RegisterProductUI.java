package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.application.RegisterProductController;
import eapli.base.product.domain.Location;
import eapli.base.product.domain.Photo;
import eapli.base.product.repository.PhotoRepository;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class RegisterProductUI extends AbstractUI{
    private final RegisterProductController controller = new RegisterProductController();

    @Override
    protected boolean doShow() {
        final String internalCode = Console.readLine("Internal Code (<24): ");
        final String productionCode = Console.readLine("Production Code (<24): ");
        final int barCode = Console.readInteger("Bar Code (EAN-13/UPC): ");
        final String brandName = Console.readLine("Brand Name (<51): ");
        final String reference = Console.readLine("Reference (<24): ");
        final String productShortDescription = Console.readLine("Product Short Description (<31): ");
        final String productExtendedDescription = Console.readLine("Product Extended Description (19> & <101): ");
        final String productTechnicalDescription = Console.readLine("Product Technical Description (>0): ");
        final String productCategory = Console.readLine("Product Category: ");
        final double priceNoTaxes = Console.readInteger("Price w/out taxes: ");
        final double priceTaxes = Console.readInteger("Price w/ taxes: ");

        int key=0;
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo();
        do{
            p.setPhotoPath(Console.readLine("Photo Path (.png/.jpeg/.svg): "));
            PhotoRepository repository = PersistenceContext.repositories().photoRepository();
            repository.save(p);
            list.add(p);
            if(Console.readInteger("Press 1 for another Photo or 2 to continue.")==2){
                key=1;
            }
        }while(key==0);

        Location l = new Location();
        l.setAisleId(Console.readInteger("AisleID: "));
        l.setRowId(Console.readInteger("RowID: "));
        l.setShelfId(Console.readInteger("ShelfID: "));

        try {
            this.controller.registerNewProduct(internalCode, productionCode, barCode, brandName, reference, productShortDescription, productExtendedDescription, productTechnicalDescription, list, productCategory, priceNoTaxes, priceTaxes, l);
        } catch (Exception e) {
            System.out.println("------------------------------------------------------------------");
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public String headline() {
        return "Register New Product";
    }
}
