package eapli.base.warehouse.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class AGV_MODEL implements ValueObject {

    String model_name;

    public AGV_MODEL( String name){

        try {
            if(this.verify(name)){
                this.model_name=name;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public AGV_MODEL() {

    }

    private boolean verify(String name){
        try{
            if(name==null)
                throw new Exception("AGV model Name cannot be null");
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }


}
