package org.KSE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BuyingEntityFactory {
//    private final Map<String, BuyingEntity> buyingEntitiesMap;

//    @Autowired
//    public BuyingEntityFactory(Map<String, BuyingEntity> buyingEntitiesMap){ // constructor injection will not work here because we need the object's real time values to instantiate it.
//        this.buyingEntitiesMap = buyingEntitiesMap;
//    }
        //use constructor injection for classes like logger.
//    public BuyingEntity getBuyingEntity(String entityType){
//        return buyingEntitiesMap.get(entityType);
//    }

    public BuyingEntity getBuyingEntity (String entityType, String companyName, Integer countOfShares, Float initialPricePerShare, Float initialCompanyWorth){
        if(entityType.equals("company")){
            return new Company(companyName, countOfShares, initialPricePerShare, initialCompanyWorth);
        }
        return new Company();
    }
}
