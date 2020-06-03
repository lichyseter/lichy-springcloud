package springcloudalibaba.controller;

import com.lichy.springcloud.entities.CommonResult;
import com.lichy.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Long, Payment> map = new HashMap<>();

    static {
        map.put(1L, new Payment(1L, "ggg1"));
        map.put(2L, new Payment(2L, "ggg2"));
        map.put(3L, new Payment(3L, "ggg3"));
    }

    @RequestMapping("/paymentSQL/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return new CommonResult<>(200, "serverPort:" + serverPort, map.get(id));
    }
}
