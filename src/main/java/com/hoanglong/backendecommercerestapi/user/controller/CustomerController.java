package com.hoanglong.backendecommercerestapi.user.controller;

import com.hoanglong.backendecommercerestapi.generates.genAPI.RestResponse;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressDto;
import com.hoanglong.backendecommercerestapi.user.dto.CustomerWithAddressSaveDto;
import com.hoanglong.backendecommercerestapi.user.entity.Customer;
import com.hoanglong.backendecommercerestapi.user.enums.CustomerMessage;
import com.hoanglong.backendecommercerestapi.user.service.entityservice.AddressEntityService;
import com.hoanglong.backendecommercerestapi.user.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final AddressEntityService addressEntityService;
    @Operation(
            tags = "Customer Controller",
            summary = "All Customers",
            description = "Gets all customers."
    )
    @GetMapping()
    public ResponseEntity<RestResponse<List<CustomerWithAddressDto>>> findAllCustomerDto(){
        List<CustomerWithAddressDto> customerWithAddressDtos = customerService.FindAllCustomerDto();
        return ResponseEntity.ok(RestResponse.of(customerWithAddressDtos, CustomerMessage.FIND_ALL_SUCCESSFUL.getDetailMessage()));
    }
    @Operation(
            tags = "Customer Controller",
            summary = "Get a Customer",
            description = "Gets a customer by id."
    )
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CustomerWithAddressDto>>  findByID(@PathVariable Long id){
        CustomerWithAddressDto customer = customerService.FindCustomerDto(id);
        return ResponseEntity.ok(RestResponse.of(customer,CustomerMessage.FIND_CUSTOMER_SUCCESSFUL.getDetailMessage()));
    }
    @Operation(
            tags="Customer Controller",
            summary = "Delete a customer",
            description = "Delete customers."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<?>> DeleteCustomer(@PathVariable Long id){
        customerService.DeleteCustomer(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
    @Operation(
            tags="Customer Controller",
            summary = "Save a customer",
            description = "Saves a new customer",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CustomerWithAddressSaveDto.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "New customer",
                                                    summary = "New customer example",
                                                    description = "Complete request with all available fields for customer.",
                                                    value = "{\"customerSaveDto\": {\n" +
                                                            "    \"emailAddress\": \"hoanglong05\",\n" +
                                                            "    \"phoneNumber\": \"19425885\",\n" +
                                                            "    \"dob\": \"2000-10-04T17:00:00.000+00:00\",\n" +
                                                            "    \"firstName\": \"Long\",\n" +
                                                            "    \"lastName\": \"Cai Hoang\",\n" +
                                                            "    \"password\": \"hoanglongne\",\n" +
                                                            "    \"gender\": true\n" +
                                                            "  },\n" +
                                                            "  \"addresses\": [\n" +
                                                            "    {\n" +
                                                            "      \"houseNumber\": \"144\",\n" +
                                                            "      \"street\": \"Nguyen Xi\",\n" +
                                                            "      \"ward\": \"26\",\n" +
                                                            "      \"district\": \"Binh Thanh\",\n" +
                                                            "      \"city\": \"TPHCM\"\n" +
                                                            "    }\n" +
                                                            "  ]}"
                                            )
                                    }
                            )
                    }
            )
    )
    @PostMapping()
    public ResponseEntity<RestResponse<CustomerWithAddressSaveDto>> SaveNewCustomer(@RequestBody CustomerWithAddressSaveDto customerWithAddressSaveDto){
         customerService.SaveNewCustomer(customerWithAddressSaveDto);
         return ResponseEntity.ok(RestResponse.of(customerWithAddressSaveDto,CustomerMessage.SAVE_SUCCESSFUL.getDetailMessage()));
    }
    @Operation(
            tags="Customer Controller",
            summary = "Update a customer",
            description = "Updates customers all fields.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerWithAddressSaveDto.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Update customer",
                                            summary = "Update customer example",
                                            description = "Complete request with all available fields for customer.",
                                            value = "{\"customerSaveDto\": {\n" +
                                                    "    \"emailAddress\": \"hoanglong05\",\n" +
                                                    "    \"phoneNumber\": \"19425885\",\n" +
                                                    "    \"dob\": \"2000-10-04T17:00:00.000+00:00\",\n" +
                                                    "    \"firstName\": \"Long\",\n" +
                                                    "    \"lastName\": \"Cai Hoang\",\n" +
                                                    "    \"password\": \"hoanglongne\",\n" +
                                                    "    \"gender\": true\n" +
                                                    "  },\n" +
                                                    "  \"addresses\": [\n" +
                                                    "    {\n" +
                                                    "      \"houseNumber\": \"144\",\n" +
                                                    "      \"street\": \"Nguyen Xi\",\n" +
                                                    "      \"ward\": \"26\",\n" +
                                                    "      \"district\": \"Binh Thanh\",\n" +
                                                    "      \"city\": \"TPHCM\"\n" +
                                                    "    }\n" +
                                                    "  ]}"
                                    )
                            }
                    )
            }
    )
    )
    @PutMapping("/{idCustomer}/{idAddress}")
    public ResponseEntity<RestResponse<CustomerWithAddressSaveDto>> UpdateCustomer(@PathVariable Long idCustomer,@PathVariable Long idAddress, @RequestBody CustomerWithAddressSaveDto customerWithAddressSaveDto){
        customerService.UpdateCustomer(idCustomer,idAddress,customerWithAddressSaveDto);
        return ResponseEntity.ok(RestResponse.of(customerWithAddressSaveDto,CustomerMessage.UPDATE_SUCCESSFUL.getMessage()));
    }
}
