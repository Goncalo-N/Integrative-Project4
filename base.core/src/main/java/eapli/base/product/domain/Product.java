package eapli.base.product.domain;

import eapli.framework.domain.model.AggregateRoot;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Product implements AggregateRoot<String>  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String internalCode;

    private String productionCode;
    private int barCode;
    private String brandName;
    private String reference;
    private String productShortDescription;
    private String productExtendedDescription;
    private String productTechnicalDescription;

    @OneToMany
    private List<Photo> photoPath;

    private String productCategory;
    private double priceNoTaxes;
    private double priceTaxes;

    @Embedded
    private Location location;

    public Product(){
    }

    public Product(String internalCode, String productionCode, int barCode, String brandName, String reference, String productShortDescription,
                   String productExtendedDescription, String productTechnicalDescription, List <Photo> photoPath, String productCategory,
                   double priceNoTaxes, double priceTaxes, Location location) {
        checkInternalCode(internalCode);
        checkProductionCode(productionCode);
        checkBrandName(brandName);
        checkReference(reference);
        checkProductShortDescription(productShortDescription);
        checkProductExtendedDescription(productExtendedDescription);
        checkProductTechnicalDescription(productTechnicalDescription);
        checkPhotoPath(photoPath);

        this.internalCode = internalCode;
        this.productionCode = productionCode;
        this.barCode = barCode;
        this.brandName = brandName;
        this.reference = reference;
        this.productShortDescription = productShortDescription;
        this.productExtendedDescription = productExtendedDescription;
        this.productTechnicalDescription = productTechnicalDescription;
        this.photoPath = photoPath;
        this.productCategory = productCategory;
        this.priceNoTaxes = priceNoTaxes;
        this.priceTaxes = priceTaxes;
        this.location = location;
    }


    private void checkPhotoPath(List<Photo> photoPath) {
        for(Photo p : photoPath){
            if(!(StringUtils.endsWithIgnoreCase(p.getPhotoPath(),".png") || StringUtils.endsWithIgnoreCase(p.getPhotoPath(),".jpeg") || StringUtils.endsWithIgnoreCase(p.getPhotoPath(),".svg"))){
                throw new IllegalArgumentException("One or more photo paths have an invalid format.");
            }
        }
    }

    private void checkProductTechnicalDescription(String productTechnicalDescription) {
        if (StringUtils.isBlank(productTechnicalDescription))
            throw new IllegalArgumentException("Product Technical Description cannot be blank.");
    }

    private void checkProductExtendedDescription(String productExtendedDescription) {
        if (StringUtils.isBlank(productExtendedDescription))
            throw new IllegalArgumentException("Product Extended Description cannot be blank.");
        if (productExtendedDescription.length() < 19 | productExtendedDescription.length() > 101)
            throw new IllegalArgumentException("Product Extended Description must have more than 19 characters and less than 101 characters.");
    }

    private void checkProductShortDescription(String productShortDescription) {
        if (StringUtils.isBlank(productShortDescription))
            throw new IllegalArgumentException("Product Short Description cannot be blank.");
        if (productShortDescription.length() > 31)
            throw new IllegalArgumentException("Product Short Description must have less than 31 characters.");
    }

    private void checkReference(String reference) {
        if (StringUtils.isBlank(reference))
            throw new IllegalArgumentException("Reference cannot be blank.");
        if (reference.length() > 24)
            throw new IllegalArgumentException("Reference must have less than 24 characters.");
    }

    private void checkBrandName(String brandName) {
        if (StringUtils.isBlank(brandName))
            throw new IllegalArgumentException("Brand Name cannot be blank.");
        if (brandName.length() > 51)
            throw new IllegalArgumentException("Brand Name must have less than 51 characters.");
    }

    private void checkProductionCode(String productionCode) {
        if (StringUtils.isBlank(productionCode))
            throw new IllegalArgumentException("Production Code cannot be blank.");
        if (productionCode.length() > 24)
            throw new IllegalArgumentException("Production Code must have less than 24 characters.");
    }

    private void checkInternalCode(String internalCode) {
        if (StringUtils.isBlank(internalCode))
            throw new IllegalArgumentException("Internal Code cannot be blank.");
        if (internalCode.length() > 24)
            throw new IllegalArgumentException("Internal Code must have less than 24 characters.");
    }

    @Override
    public String identity() {
        return String.valueOf(this.internalCode);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getProductShortDescription() {
        return productShortDescription;
    }

    public void setProductShortDescription(String productShortDescription) {
        this.productShortDescription = productShortDescription;
    }

    public String getProductExtendedDescription() {
        return productExtendedDescription;
    }

    public void setProductExtendedDescription(String productExtendedDescription) {
        this.productExtendedDescription = productExtendedDescription;
    }

    public String getProductTechnicalDescription() {
        return productTechnicalDescription;
    }

    public void setProductTechnicalDescription(String productTechnicalDescription) {
        this.productTechnicalDescription = productTechnicalDescription;
    }

    public List <Photo> getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(List <Photo> photoPath) {
        this.photoPath = photoPath;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getPriceNoTaxes() {
        return priceNoTaxes;
    }

    public void setPriceNoTaxes(double priceNoTaxes) {
        this.priceNoTaxes = priceNoTaxes;
    }

    public double getPriceTaxes() {
        return priceTaxes;
    }

    public void setPriceTaxes(double priceTaxes) {
        this.priceTaxes = priceTaxes;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Product)) {
            return false;
        }

        final Product that = (Product) other;

        if (this == that) {
            return true;
        }

        return identity().equals(that.identity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && barCode == product.barCode && Double.compare(product.priceNoTaxes, priceNoTaxes) == 0 && Double.compare(product.priceTaxes, priceTaxes) == 0 && Objects.equals(internalCode, product.internalCode) && Objects.equals(productionCode, product.productionCode) && Objects.equals(brandName, product.brandName) && Objects.equals(reference, product.reference) && Objects.equals(productShortDescription, product.productShortDescription) && Objects.equals(productExtendedDescription, product.productExtendedDescription) && Objects.equals(productTechnicalDescription, product.productTechnicalDescription) && Objects.equals(photoPath, product.photoPath) && Objects.equals(productCategory, product.productCategory) && Objects.equals(location, product.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, internalCode, productionCode, barCode, brandName, reference, productShortDescription, productExtendedDescription, productTechnicalDescription, photoPath, productCategory, priceNoTaxes, priceTaxes, location);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", internalCode='" + internalCode + '\'' +
                ", productionCode='" + productionCode + '\'' +
                ", barCode=" + barCode +
                ", brandName='" + brandName + '\'' +
                ", reference='" + reference + '\'' +
                ", productShortDescription='" + productShortDescription + '\'' +
                ", productExtendedDescription='" + productExtendedDescription + '\'' +
                ", productTechnicalDescription='" + productTechnicalDescription + '\'' +
                ", photoPath=" + photoPath +
                ", productCategory='" + productCategory + '\'' +
                ", priceNoTaxes=" + priceNoTaxes +
                ", priceTaxes=" + priceTaxes +
                ", location=" + location +
                '}';
    }
}
