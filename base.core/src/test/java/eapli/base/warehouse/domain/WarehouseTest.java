package eapli.base.warehouse.domain;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.base.warehouse.aisle.domain.coordinates;
import eapli.base.warehouse.rows.domain.Rows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WarehouseTest {
    public WarehouseTest(){

    }
    @Test(expected = IllegalArgumentException.class)
    public void testLength(){
        System.out.println("Length test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(null,10L,10L,"cm",aisleList,agvdockList);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testWidth(){
        System.out.println("Width test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,null,10L,"cm",aisleList,agvdockList);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testSquare(){
        System.out.println("Square test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,10L,null,"cm",aisleList,agvdockList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnitEmpty(){
        System.out.println("Unit empty test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,10L,10L,"",aisleList,agvdockList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnitNull(){
        System.out.println("Unit null test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,10L,10L,null,aisleList,agvdockList);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAisleListNull(){
        System.out.println("Aisle list null test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,10L,10L,"cm",null,agvdockList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAisleListEmpty(){
        System.out.println("Aisle list empty test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        List<Aisle> aisleList = new ArrayList<>();

        //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,10L,10L,"cm",aisleList,agvdockList);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAGVDockListNull(){
        System.out.println("AGVDock list null test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
       //AGVDOCK agvdock = new AGVDOCK("ab",CoordinatesB,CoordinatesE,CoordinatesD,"-m");
        List<AGVDOCK> agvdockList = new ArrayList<>();
        //agvdockList.add(agvdock);

        Warehouse instanceWarehouse = new Warehouse(10L,10L,10L,"cm",aisleList,null);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAGVDockListEmpty(){
        System.out.println("AGVDock list empty test");

        coordinates CoordinatesB = new coordinates(2,3);
        coordinates CoordinatesE = new coordinates(2,3);
        coordinates CoordinatesD = new coordinates(2,3);
        List<Rows> rowsList = new ArrayList<>();
        Rows rowExample = new Rows(1L,CoordinatesB,CoordinatesE,5L);
        rowsList.add(rowExample);
        Aisle aisle = new Aisle(1L,CoordinatesB,CoordinatesE,CoordinatesD,"-l",rowsList);
        List<Aisle> aisleList = new ArrayList<>();
        aisleList.add(aisle);
        List<AGVDOCK> agvdockList = new ArrayList<>();

        Warehouse instanceWarehouse = new Warehouse(10L,10L,10L,"cm",aisleList,agvdockList);

    }

}