package com.example.apetito.controller;

import com.example.apetito.config.JwtService;
import com.example.apetito.dto.CartItem;
import com.example.apetito.dto.DataToCreateOrder;
import com.example.apetito.model.*;
import com.example.apetito.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {

    @Autowired
    private JwtService jwtService;
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
    @Autowired
    private OrderTableProductService orderTableProductService;

    @GetMapping("/menuFromRestaurant/{id}")
    public Iterable<Product> getMenuFromRestaurant(@PathVariable Long id){
        return productService.getRestaurantMenu(id);
    }

    @GetMapping("/clients/orders/all")
    public Iterable<OrderTable> getAllClientOrders() throws Exception {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        UserDetails principal = (UserDetails) authentication.getPrincipal();

        return orderTableService.getOrdersByClientId(clientService.findClientIdByEmail(principal.getUsername()));
    }
    /*
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
    
     */

    @GetMapping("/orders/restaurant/{id}")
    public List<OrderTableProduct> getAllOrdersByRestaurantId(@PathVariable Long id) {
        return orderTableProductService.ordersForRestaurant(id);
    }

    @GetMapping("/deliveryCompanies")
    public Iterable<DeliveryCompany> getDeliveryCompanies(){
        return deliveryCompanyService.getAllDeliveryCompanies();
    }

    @GetMapping("/orders/deliveryCompanies/{id}")
    public List<OrderTable> getOrdersByDeliveryCompany(@PathVariable Long id) {
        // Wywołaj serwis lub repozytorium, aby pobrać zamówienia dostawcze dla firmy dostawczej o danym id
        List<OrderTable> orders = orderTableService.getOrdersByDeliveryCompanyId(id);
        return orders;
    }

    /*
    @GetMapping("/orders/userOrders")
    public ResponseEntity<List<OrderTable>> getOrders(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = userDetails.
                List<OrderTable> orderTable = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orderTable);
    }

     */

    @PostMapping("/deliveryAddress")
    public void addDeliveryAddress(@RequestBody DeliveryAddress address) {
        deliveryAddressService.addDeliveryAddress(address);
    }
    @PostMapping("/createOrder")
    public ResponseEntity<OrderTable> createOrder(@RequestBody DataToCreateOrder dataToCreateOrder) throws Exception {


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
        order.setIsFinished(false);
        order.setDeliveryAddress(deliveryAddress);
        Optional<DeliveryCompany> deliveryCompany = deliveryCompanyService.getDeliveryCompanyByID(dataToCreateOrder.getDeliveryCompanyID());

        if (deliveryCompany.isPresent()) {
            order.setDeliveryCompany(deliveryCompany.get());
        } else {
            order.setDeliveryCompany(null);
        }

        order = orderTableService.addOrderTable(order);

        if (dataToCreateOrder.getCartItems() != null) {
            for (CartItem cartItem : dataToCreateOrder.getCartItems()) {

                Optional<Product> product = productService.getProductById(cartItem.getId());
                if (product.isPresent()) {
                    OrderTableProduct orderProduct = new OrderTableProduct();
                    orderProduct.setNumber(cartItem.getQuantity());
                    orderProduct.setProduct(product.get());
                    orderProduct.setOrder(order);
                    orderTableProductService.addOrderTableProduct(orderProduct);
                } else {
                    throw new Exception("Cannot find product with ID: " + cartItem.getId());
                }
            }
        } else {
            throw new Exception("CartItem is null");
        }

        return ResponseEntity.ok(order);
    }

    /*
    @PostMapping("/clients/add")
    public ResponseEntity<?> registerClient(@RequestBody Client client) {
        Optional<Client> existingClient = clientService.findClientByEmail(client.getEmail());
        if (existingClient.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ten adres e-mail jest już używany.");
        }
        Client newClient = clientService.addClient(client);
        return ResponseEntity.ok(newClient);
    }

*/

}
