package com.example.apetito.controler;

import com.example.apetito.DataToCreateOrder;
import com.example.apetito.model.*;
import com.example.apetito.repository.ClientRepository;
import com.example.apetito.repository.DeliveryAddressRepository;
import com.example.apetito.repository.DeliveryCompanyRepository;
import com.example.apetito.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;


import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private DishTypeService dishTypeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DeliveryCompanyService deliveryCompanyService;
    @Autowired
    private DeliveryAddressService deliveryAddressService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrderTableService orderTableService;

    @GetMapping("/allRestaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurants(@PathVariable Long id){
        return restaurantService.getRestaurant(id);
    }
    @GetMapping("/restaurant/image/{id}")
    public ResponseEntity<Resource> getRestaurantImage(@PathVariable Long id) throws Exception {

        Restaurant restaurant = restaurantService.getRestaurant(id).orElseThrow(() -> new Exception("Cannot find restaurant"));
        String imageName = restaurant.getResultPhotoUrl();

        Resource resource = new ClassPathResource("photos/restaurant/" + imageName);
        return ResponseEntity.ok().body(resource);
    }
    @GetMapping("/allDishTypes")
    public Iterable<DishType> getAllDishTypes() {
        return dishTypeService.getAllDishTypes();
    }

    @GetMapping("/menuFromRestaurant/{id}")
    public Iterable<Product> getMenuFromRestaurant(@PathVariable Long id){
        return productService.getRestaurantMenu(id);
    }

    @GetMapping("/dishType/image/{id}")
    public ResponseEntity<Resource> getDishTypeImage(@PathVariable Long id) throws Exception {

        DishType dishType = dishTypeService.getDishType(id).orElseThrow(() -> new Exception("Cannot find dish type"));
        String imageName = dishType.getPhotoUrl();

        Resource resource = new ClassPathResource("photos/" + imageName);
        return ResponseEntity.ok().body(resource);
    }

    @GetMapping("/product/image/{id}")
    public ResponseEntity<Resource> getProductImage(@PathVariable Long id) throws Exception {

        Product product = productService.getProductById(id)
                .orElseThrow(() -> new Exception("Cannot find product"));
        String imageName = product.getPhotoUrl();
        if (imageName == null || imageName.isEmpty()) {
            throw new FileNotFoundException("Image not found for product with ID: " + id);
        }

        Resource resource = new ClassPathResource("photos/product/" + imageName);
        return ResponseEntity.ok().body(resource);
    }
    @GetMapping("/deliveryCompanies")
    public Iterable<DeliveryCompany> getDeliveryCompanies(){
        return deliveryCompanyService.getAllDishTypes();
    }

    @PostMapping("/deliveryAddress")
    public void addDeliveryAddress(@RequestBody DeliveryAddress address) {
        deliveryAddressService.addDeliveryAddress(address);
    }
    @PostMapping("/createOrder")
    public ResponseEntity<OrderTable> createOrder(@RequestBody DataToCreateOrder dataToCreateOrder) {
        Client client = new Client();
        client.setName(dataToCreateOrder.getName());
        client.setSurname(dataToCreateOrder.getSurname());
        client.setEmail(dataToCreateOrder.getEmail());
        client.setPhoneNumber(dataToCreateOrder.getPhoneNumber());
        client = clientService.addClient(client);

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setNIP(dataToCreateOrder.getNIP());
        deliveryAddress.setFloor(dataToCreateOrder.getFloor());
        deliveryAddress.setBuildingNumber(dataToCreateOrder.getBuildingNumber());
        deliveryAddress.setStreet(dataToCreateOrder.getStreet());
        deliveryAddress.setGateCode(dataToCreateOrder.getGateCode());
        deliveryAddress.setZipCode(dataToCreateOrder.getZipCode());
        deliveryAddress.setCompanyName(dataToCreateOrder.getCompanyName());
        deliveryAddress.setNote(dataToCreateOrder.getNote());
        deliveryAddress = deliveryAddressService.addDeliveryAddress(deliveryAddress);

        OrderTable order = new OrderTable();
        order.setOrderDate(LocalDateTime.now());
        order.setClient(client);
        order.setIsFinished(false);
        order.setDeliveryAddress(deliveryAddress);
        Optional<DeliveryCompany> deliveryCompany = deliveryCompanyService.getDeliveryCompanyByID(dataToCreateOrder.getDeliveryCompanyID());

        if (deliveryCompany.isPresent()) {
            order.setDeliveryCompany(deliveryCompany.get());
        } else {
            order.setDeliveryCompany(null);
        }

        order = orderTableService.addOrderTable(order);

        return ResponseEntity.ok(order);
    }
    @PostMapping("/createClientWithoutAccount")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/restaurant/banner/{id}")
    public ResponseEntity<Resource> getRestaurantBanner(@PathVariable Long id) throws Exception {

        Restaurant restaurant = restaurantService.getRestaurant(id).orElseThrow(() -> new Exception("Cannot find restaurant"));
        String imageName = restaurant.getBannerUrl();

        Resource resource = new ClassPathResource("photos/restaurant/banner/" + imageName);
        return ResponseEntity.ok().body(resource);
    }

}
