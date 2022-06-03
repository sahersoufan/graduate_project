package com.grad.exchangesys.Controller;


import com.grad.exchangesys.Model.Contract;
import com.grad.exchangesys.Model.User;
import com.grad.exchangesys.Services.ContractCheckServices;
import com.grad.exchangesys.Services.ContractService;
import com.grad.exchangesys.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/contract")
public class ContractController {

        private final ContractService contractService;
        private final ContractCheckServices contractCheckServices;
        private final UserService userService;



        @GetMapping("/")
        public List<Contract> get_all_contract(HttpServletRequest request){
            User user = userService.getUser(request);
            return contractService.get_My_Contracts(user.getId());
        }


        @PostMapping("/create")
    public String new_contract(HttpServletRequest request , Contract contract) {

            User user1 = userService.getUser(request);
            contractService.newContract(contract);
            if (!contractCheckServices.check_if_existed(contract))
            {
                contractService.newContract(contract);
                return "added new Contract";
            }

            else if(contractCheckServices.check_if_existed(contract) && contractCheckServices.check_and_replace(contract))
            {
                System.out.println("the contract is true  ");
                return "the contract is already existed and true " ;
            }
            else if(contractCheckServices.check_if_existed(contract) && !contractCheckServices.check_and_replace(contract))
            {
                System.out.println("the contract is not true  ");
                if (contractService.deleteContract(contract.getContract_Serial_Number())) {
                    return "the contract is not true and deleted ";
                }

            }
        return "";
        }


}
//if(!contractCheckServices.check_if_existed(contract))
//        return contractService.newContract(contract);
//        if(contractCheckServices.check_if_existed(contract) && contractCheckServices.check_if_contract_istrue(contract)){
//        System.out.println("the contract is existed and true  " );
//        return contract;
//        }
//        if(contractCheckServices.check_if_existed(contract) && !contractCheckServices.check_if_contract_istrue(contract)){
//        System.out.println("the contract is existed and not a true contract  \n the contract was edited form som one " );
//        return contract;
//        }


/*
*  User user2 = userService.getUser(id_user2);
            File contract_file = new File("Contract/"+user1.getId());
            FileWriter fileWriter = new FileWriter(contract_file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            }*/