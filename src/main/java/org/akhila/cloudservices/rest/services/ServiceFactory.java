package org.akhila.cloudservices.rest.services;

import org.akhila.cloudservices.rest.DataBaseConnectionProvider;

import java.sql.SQLException;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private CustomerService customerService;
    private EmployeeService employeeService;
    private OfficeService officeService;
    private OrderDetailsService orderDetailsService;
    private OrderService orderService;
    private PaymentService paymentService;
    private ProductLinesService productLinesService;
    private ProductService productService;

    private ServiceFactory() throws SQLException, ClassNotFoundException {
        final DataBaseConnectionProvider dataBaseConnectionProvider = DataBaseConnectionProvider.getDatabaseProvider();
        customerService = new CustomerServiceImpl(dataBaseConnectionProvider);
        employeeService = new EmployeeServiceImpl(dataBaseConnectionProvider);
        officeService = new OfficeServiceImpl(dataBaseConnectionProvider);
        orderDetailsService = new OrderDetailsServiceImpl(dataBaseConnectionProvider);
        orderService = new OrderServiceImpl(dataBaseConnectionProvider);
        paymentService = new PaymentServiceImpl(dataBaseConnectionProvider);
        productLinesService = new ProductLinesServiceImpl();
        productService = new ProductServiceImpl(dataBaseConnectionProvider);
    }

    public synchronized static ServiceFactory getServiceFactory() throws SQLException, ClassNotFoundException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public OfficeService getOfficeService() {
        return officeService;
    }

    public OrderDetailsService getOrderDetailsService() {
        return orderDetailsService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public ProductLinesService getProductLinesService() {
        return productLinesService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
