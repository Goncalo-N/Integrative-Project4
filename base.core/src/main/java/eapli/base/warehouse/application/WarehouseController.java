package eapli.base.warehouse.application;

import eapli.base.warehouse.agvdock.domain.AGVDOCK;
import eapli.base.warehouse.aisle.domain.Aisle;
import eapli.base.warehouse.aisle.domain.coordinates;
import eapli.base.warehouse.agv.application.AGVController;
import eapli.base.warehouse.agv.domain.AGV;
import eapli.base.warehouse.agv.domain.AGV_MODEL;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.ProductOrder;
import eapli.base.warehouse.repository.ProductOrderRepository;
import eapli.base.warehouse.rows.domain.Rows;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.repository.WarehouseRepository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class WarehouseController {

    public static List<AGVDOCK> agvDockList = new ArrayList<>();
    public static List<Aisle> aisleList = new ArrayList<>();
    public static List<Rows> rowsList = new ArrayList<>();
    public static List<Rows> currentRowList = new ArrayList<>();
    private final WarehouseRepository repository = PersistenceContext.repositories().warehouseRepository();
    private final ProductOrderRepository productOrderRepository = PersistenceContext.repositories().productOrderRepository();

    public void registerNewWarehouse(Long length, Long width, Long square, String unit, List<Aisle> aisles, List<AGVDOCK> AGVDOCKS) {
        final Warehouse newWarehouse = new Warehouse(length, width, square, unit, aisles, AGVDOCKS);
        System.out.println(newWarehouse);
        //this.repository.save(newWarehouse);
    }
        public Warehouse getWarehouseById (Long id){

            return this.repository.warehouseByID(id);
        }

        public List<AGVDOCK> listAGVDOCKS (Long id){
            return repository.warehouseByID(id).getAGVDOCKS();
        }


        public AGV updateAGV (Long id, String description, AGV_MODEL model, double max_weigth, double volume, AGVDOCK
        agvdock){
            final AGVController AGVcontroller = new AGVController();

            AGV finalAGV = AGVcontroller.updateAGV(id, description, model, max_weigth, volume, agvdock);

            return finalAGV;

        }

public void uploadJSONFile(String jsonFileName){
    JSONParser parser = new JSONParser();
        try {
        Object obj = parser.parse(new FileReader(jsonFileName));

        // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
        JSONObject jsonObject = (JSONObject) obj;

        // A JSON array. JSONObject supports java.util.List interface.

        String warehouseName = (String) jsonObject.get("Warehouse");
        Long length = (Long) jsonObject.get("Length");
        Long width = (Long) jsonObject.get("Width");
        Long square = (Long) jsonObject.get("Square");
        String unit = (String) jsonObject.get("Unit");
        System.out.println("Warehouse name:" + warehouseName + ";\nLength:" + length + ";\nWidth:" + width + ";\nSquare:" + square + ";\nUnits:" + unit);

        JSONArray JSONObjectAisles = (JSONArray) jsonObject.get("Aisles");
        JSONArray JSONObjectAGVDocks = (JSONArray) jsonObject.get("AGVDocks");
        List<Integer> Aisles = new ArrayList<>(); //Array list com os Ids dos Aisles
        List<String> Accessibility = new ArrayList<>(); //Array list com as quantidades de shelves

        JSONObjectAisles.forEach(jsonObject2 -> parseEmpObj((JSONObject) jsonObject2));
        JSONObjectAGVDocks.forEach(jsonObject3 -> parseEmpObj2((JSONObject) jsonObject3));
        // System.out.println("Aisle List:"+aisleList+"\n");
        // System.out.println("Rows List:"+rowsList+"\n");
        //System.out.println("AGVDock List"+agvDockList+"\n");
        registerNewWarehouse(length,width,square,unit,aisleList,agvDockList);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private static void parseEmpObj(JSONObject emp) {
        System.out.println();
        //get aisleID
        Long aisleID= (Long) emp.get("Id");
        //System.out.println("Aisle ID :"+aisleID);
        JSONObject empObj = (JSONObject) emp.get("begin");
        //get lsquare wsquare

        coordinates coordenadasB1 = new coordinates();
        coordenadasB1.setLsquare((Long) empObj.get("lsquare"));
        coordenadasB1.setWsquare((Long) empObj.get("wsquare"));
        //Long lsquare = (Long) empObj.get("lsquare");
        //Long wsquare = (Long) empObj.get("wsquare");
        //System.out.println("Begin:'lsquare': "+lsquare.intValue());
        //System.out.println("Begin:'wsquare':"+wsquare.intValue());


        JSONObject empObjend = (JSONObject) emp.get("end");
        coordinates coordenadasE1 = new coordinates();
        coordenadasE1.setLsquare((Long) empObjend.get("lsquare"));
        coordenadasE1.setWsquare((Long) empObjend.get("wsquare"));
        //lsquare = (Long) empObj.get("lsquare");
        // wsquare = (Long) empObj.get("wsquare");
        // System.out.println("End:'lsquare': "+lsquare.intValue());
        //System.out.println("End:'wsquare':"+wsquare.intValue());

        JSONObject empObjdepth = (JSONObject) emp.get("depth");

        coordinates coordenadasD1 = new coordinates();
        coordenadasD1.setLsquare((Long) empObjdepth.get("lsquare"));
        coordenadasD1.setWsquare((Long) empObjdepth.get("wsquare"));
         // lsquare = (Long) empObj.get("lsquare");
         // wsquare = (Long) empObj.get("wsquare");
        //System.out.println("Begin:'lsquare': "+lsquare.intValue());
        //System.out.println("Begin:'wsquare':"+wsquare.intValue());

        String AisleAcc = (String) emp.get("accessibility");
        //System.out.println("AGVDock accessibility:"+AisleAcc);
        JSONArray JSONObjectAisleRows = (JSONArray) emp.get("rows");
        JSONObjectAisleRows.forEach(jsonObject4->parseEmpObj3((JSONObject)jsonObject4));
        Aisle variableAisle = new Aisle(aisleID,coordenadasB1,coordenadasE1,coordenadasD1,AisleAcc,currentRowList);
        aisleList.add(variableAisle);
        currentRowList.clear();

    }
    private static void parseEmpObj2(JSONObject emp) {
        //System.out.println();

        JSONObject empObj = (JSONObject) emp.get("begin");
        String AGVDocks = (String) emp.get("Id");
        //System.out.println("AGVDock ID:"+AGVDocks);
        //get lsquare wsquare

        coordinates coordenadasB2 = new coordinates();
        coordenadasB2.setLsquare((Long) empObj.get("lsquare"));
        coordenadasB2.setWsquare((Long) empObj.get("wsquare"));
        //Long lsquare = (Long) empObj.get("lsquare");
        //Long wsquare = (Long) empObj.get("wsquare");
        //System.out.println("AGV Begin:'lsquare': "+lsquare.intValue());
        //System.out.println("AGV Begin:'wsquare':"+wsquare.intValue());

        JSONObject empObjend = (JSONObject) emp.get("end");
        coordinates coordenadasE2 = new coordinates();
        coordenadasE2.setLsquare((Long) empObjend.get("lsquare"));
        coordenadasE2.setWsquare((Long) empObjend.get("wsquare"));
        //lsquare = (Long) empObjend.get("lsquare");
        //wsquare = (Long) empObjend.get("wsquare");
        //System.out.println("AGV End:'lsquare': "+lsquare.intValue());
        //System.out.println("AGV End:'wsquare':"+wsquare.intValue());


        JSONObject empObjdepth = (JSONObject) emp.get("depth");
        coordinates coordenadasD2 = new coordinates();
        coordenadasD2.setLsquare((Long) empObjdepth.get("lsquare"));
        coordenadasD2.setWsquare((Long) empObjdepth.get("wsquare"));
        //lsquare = (Long) empObjdepth.get("lsquare");
        //wsquare = (Long) empObjdepth.get("wsquare");
        //System.out.println("AGV End:'lsquare': "+lsquare.intValue());
        //System.out.println("AGV End:'wsquare':"+wsquare.intValue());

        String AGVDocksAcc = (String) emp.get("accessibility");
        //System.out.println("AGVDock accessibility:"+AGVDocksAcc);
        //AGVDOCK variableAGVDOCK = new AGVDOCK(AGVDocks,coordenadasB2,coordenadasE2,coordenadasD2,AGVDocksAcc);
       // agvDockList.add(variableAGVDOCK);

    }
    private static void parseEmpObj3(JSONObject emp) {
        System.out.println();

        JSONObject empObj = (JSONObject) emp.get("begin");
        Long rowsID = (Long) emp.get("Id");
        //System.out.println("Rows ID:"+rowsID);
        //get lsquare wsquare
        coordinates coordenadasB3 = new coordinates();
        coordenadasB3.setLsquare((Long) empObj.get("lsquare"));
        coordenadasB3.setWsquare((Long) empObj.get("wsquare"));
        //Long lsquarer = (Long) empObj.get("lsquare");
        //Long wsquarer = (Long) empObj.get("wsquare");
        //System.out.println("Rows Begin:'lsquare': "+lsquare.intValue());
        //System.out.println("Rows Begin:'wsquare':"+wsquare.intValue());

        JSONObject empObjend = (JSONObject) emp.get("end");
        coordinates coordenadasE3 = new coordinates();
        coordenadasE3.setLsquare((Long) empObjend.get("lsquare"));
        coordenadasE3.setWsquare((Long) empObjend.get("wsquare"));

        //lsquarer = (Long) empObjend.get("lsquare");
        //wsquarer = (Long) empObjend.get("wsquare");
        //System.out.println("Rows End:'lsquare': "+lsquare.intValue());
        //System.out.println("Rows End:'wsquare':"+wsquare.intValue());
        Long rowsShelves= (Long) emp.get("shelves");
        //System.out.println("Rows shelves:"+rowsShelves);
        Rows currentRow = new Rows(rowsID,coordenadasB3,coordenadasE3,rowsShelves);
        rowsList.add(currentRow);
        currentRowList.add(currentRow);
    }

    /**
     * Retorna a Lista de Product Orders Prontas para serem atualizadas como enviadas para o cliente
     * @return ProducctOrder
     */
    public ProductOrder geFirstfReadyProductOrder(){
        return this.productOrderRepository.getFirstReadyProductOrder();
    }

    public List<ProductOrder> getAllReadyProductOrders(){
        return this.productOrderRepository.getAllReadyProductOrders();
    }

    /**
     * Retorna a product order com o ID selecionado
     * @param id Id da product order a ser retornada
     * @return ProductOrder
     */
    public ProductOrder getProductOrderById(Long id){
        return this.productOrderRepository.productOrderByID(id);
    }

    /**
     * dá update a product order selecionada como "enviada para o cliente"
     * @param productOrder Product Order a ser atualizada
     */
    public void updateProductOrderToSentToClient(ProductOrder productOrder){
        this.productOrderRepository.updateProductOrderSentToClient(productOrder.getId());
    }

}
