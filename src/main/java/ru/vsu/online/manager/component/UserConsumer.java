package ru.vsu.online.manager.component;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vsu.online.manager.pojo.Purchase;
import ru.vsu.online.manager.service.ShopService;

@Component
@AllArgsConstructor
public class UserConsumer {

    private final ShopService shopService;

    public void onMessage(Purchase purchase){
        shopService.doPurchase(purchase);
    }
}
