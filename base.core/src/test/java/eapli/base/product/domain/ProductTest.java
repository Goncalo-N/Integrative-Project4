package eapli.base.product.domain;

import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Birthday;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Gender;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static eapli.base.customer.domain.Gender.Male;
import static org.junit.Assert.*;

public class ProductTest {

    public ProductTest() {

    }

    @Test
    public void testSameAs() {
        System.out.println("sameAs");

        //Tests for a null comparison
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
        boolean result = instance.sameAs(null);
        assertFalse(result);

        //Tests for same fields but different internal code
        Product instance2 = new Product("Test1235661", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
        boolean result2 = instance.sameAs(instance2);
        assertFalse(result2);

        //Tests for equal object
        Product instance3 = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
        boolean result3 = instance.sameAs(instance3);
        assertTrue(result3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInternalCode() {
        System.out.println("checkInternalCode");

        //Tests if internal code is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product(null, "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if internal code has more than 24 characters
        Product instance2 = new Product("fdkjouauggahdfuigaeohuigadehgauigheraiua", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkProductionCode() {
        System.out.println("checkProductionCode");

        //Tests if production code is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", null, 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if production code has more than 24 characters
        Product instance2 = new Product("Test123", "Test456gerygrufhergiergertguhfdrgdrguh", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkBrandName() {
        System.out.println("checkBrandName");

        //Tests if brand name is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, null, "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if brand name has more than 51 characters
        Product instance2 = new Product("Test123", "Test456", 123456688, "Test789duhdfsuhfsdghrguhfsuihgfsuihdfgfdgfguhsfdtgeruhuhegfdfdjghsghjiksuhkj", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkReference() {
        System.out.println("checkReference");
        //tests if reference is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, "Test789", null, "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if reference has more than 24 characters
        Product instance2 = new Product("Test123", "Test456", 123456688, "Test789", "TestABC53155131314141413414", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkProductShortDescription() {
        System.out.println("checkProductShortDescription");

        //Tests if product short description is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", null, "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if product short description has more than 31 characters
        Product instance2 = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEFfdjghkalfdgjhkfdgjkbfjjjfjjjfuijj", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkProductExtendedDescription() {
        System.out.println("checkProductExtendedDescription");

        //Tests if product extended description is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", null, "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if product extended description has more than 101 characters
        Product instance2 = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIsdrhisfygsygfsbyhifsdhiobfsdhisdgghfsdghhdgsdsfhiogjhkgsdfdfhouiofsdguuhfasfwrgysfwrghfwehjehjdeuiuiofsdguifgsd", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

        //Tests if product extended description has less than 19 characters
        Product instance3 = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHI", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkProductTechicalDescription() {
        System.out.println("checkProductTechnicalDescription");

        //Tests if product technical description is null
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.png");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", null, list, "TestMNO", 25, 30, new Location(1,2,3));

    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPhotoPath() {
        System.out.println("checkPhotoPath");

        //Tests if photo path is wrong
        List<Photo> list = new ArrayList<>();
        Photo p = new Photo("test.omegalul");
        list.add(p);
        Product instance = new Product("Test123", "Test456", 123456688, "Test789", "TestABC", "TestDEF", "TestGHIINEEDMORECHARACTERS", "TestJKL", list, "TestMNO", 25, 30, new Location(1,2,3));

    }
}