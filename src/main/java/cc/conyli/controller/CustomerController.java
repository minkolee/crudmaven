package cc.conyli.controller;

import cc.conyli.entity.Customer;
import cc.conyli.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(value = "/list")
    public String test(Model model) {

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping(value = "/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping(value = "/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/showFormForUpdate")
    public String updateCustomer(@RequestParam("customerId") int customerId, Model model) {
        //获取customerId对应的customer对象
        Customer customer = customerService.getCustomer(customerId);

        //将customer对象设置到model上去
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping(value = "/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {

        customerService.deleteCustomer(customerId);

        return "redirect:/customer/list";
    }
}
