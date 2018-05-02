package com.bage.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.bage.domain.Account;
import com.bage.domain.AccountForm;
import com.bage.domain.AccountUpdateForm;
import com.bage.domain.Client;
import com.bage.domain.Pet;
import com.bage.domain.User;

// @SessionAttributes("pet") 暂时注释掉
@Controller
@RequestMapping("/requestMapping")
public class RequestMappingController {

	
	// The Errors or BindingResult parameters have to follow the model object that is being bound immediately as the method signature might have more than one model object and Spring will create a separate BindingResult instance for each of them so the following sample won’t work:
	// Invalid ordering of BindingResult and @ModelAttribute
	@PostMapping("processSubmit1")
	public String processSubmit(@ModelAttribute("pet") Pet pet, Model model, BindingResult result) { 
		return "";
	}
	
	// Note, that there is a Model parameter in between Pet and BindingResult. To get this working you have to reorder the parameters as follows:
	@PostMapping("processSubmit2")
	public String processSubmit(@ModelAttribute("pet") Pet pet, BindingResult result, Model model) {
		return "";
	}
	
	
	// Supported method return types
	// If the method is annotated with @ResponseBody, the return type is written to the response HTTP body
	@PostMapping("processSubmit3")
	public String processSubmit() {
		// ModelAndView 
		// Rendering
		// Model 
		// Map 
		// View 
		// String 
		// void
		// ...
		return "";
	}
	
	
	// Binding request parameters to method parameters with @RequestParam
	@GetMapping("processSubmit4")
    public String setupForm(@RequestParam("petId") int petId, ModelMap model) {
            Pet pet = new Pet(petId);
            model.addAttribute("pet", pet);
            return "petForm";
    }
	
	
	// Mapping the request body with the @RequestBody annotation
	@PutMapping("/something")
	public void handle(@RequestBody String body, Writer writer) throws IOException {
	        writer.write(body);
	}
	
	
	// Mapping the response body with the @ResponseBody annotation
	@GetMapping("/something")
	@ResponseBody
	public String helloWorld() {
	        return "Hello World";
	}
	
	
	// Creating REST Controllers with the @RestController annotation
	// For convenience, instead of annotating all your @RequestMapping methods with @ResponseBody, you can annotate your controller Class with @RestController.
	
	
	// Using HttpEntity
	@RequestMapping("/something")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
	        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
	        byte[] requestBody = requestEntity.getBody();

	        // do something with request header and body
	        System.out.println(requestHeader + requestBody);
	        HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.set("MyResponseHeader", "MyValue");
	        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	}
	
	
	// Using @ModelAttribute on a method
	// Add one attribute
	// The return value of the method is added to the model under the name "account"
	// You can customize the name via @ModelAttribute("myAccount")

	@ModelAttribute
	public Account addAccount(@RequestParam String number) {
	        return new Account(number);
	}
	// Add multiple attributes
	@ModelAttribute
	public void populateModel(@RequestParam String number, Model model) {
	        model.addAttribute(new Account(number));
	        // add more ...
	}
	
	
	// Using @ModelAttribute on a method argument
	@PostMapping("/owners1/{ownerId}/pets/{petId}/edit")
	public String processSubmit(@ModelAttribute Pet pet) {
		return "";
	}
	@PutMapping("/accounts/{account}")
	public String save(@ModelAttribute("account") Account account) {
	       return "";
	}
	@PostMapping("/owners2/{ownerId}/pets/{petId}/edit")
	public String processSubmit(@ModelAttribute("pet") Pet pet, BindingResult result) {
	        if (result.hasErrors()) {
	                return "petForm";
	        }
	        return "";

	}
	
	
	// Note that in some cases it may be useful to gain access to an attribute in the model without data binding
	@ModelAttribute
	public AccountForm setUpForm() {
	    return new AccountForm();
	}
	@ModelAttribute
	public Account findAccount(@PathVariable String accountId) {
	    return new Account(accountId);
	}
	@PostMapping("update")
	public String update(AccountUpdateForm form, BindingResult result,
	        @ModelAttribute(binding=false) Account account) {
	    	return "";
	}
	
	
	// In addition to data binding you can also invoke validation using your own custom validator passing the same BindingResult that was used to record data binding errors
	@PostMapping("/owners/{ownerId}/pets/{petId}/edit")
	public String processSubmitValidate(@ModelAttribute("pet") Pet pet, BindingResult result) {
			// new PetValidator().validate(pet, result); // 暂时注释掉
	        if (result.hasErrors()) {
	                return "petForm";
	        }
	        return "";

	}
	
	
	// Using @SessionAttributes to store model attributes in the HTTP session between requests
	// 类定义也可以添加 @SessionAttributes("pet")
	@RequestMapping("/handle1")
	public String handle(@SessionAttribute User user) {
	       return "";
	}
	
	
	// Using @RequestAttribute to access request attributes
	@RequestMapping("/handle2")
	public String handle(@RequestAttribute Client client) {
	       return "";
	}
	
	
	// Mapping cookie values with the @CookieValue annotation
	@RequestMapping("/displayHeaderInfo.do1")
	public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie) {
	        //...
	}
	
	
	// Mapping request header attributes with the @RequestHeader annotation
	@RequestMapping("/displayHeaderInfo.do2")
	public void displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,
	                @RequestHeader("Keep-Alive") long keepAlive) {
//		Host                    localhost:8080
//		Accept                  text/html,application/xhtml+xml,application/xml;q=0.9
//		Accept-Language         fr,en-gb;q=0.7,en;q=0.3
//		Accept-Encoding         gzip,deflate
//		Accept-Charset          ISO-8859-1,utf-8;q=0.7,*;q=0.7
//		Keep-Alive              300
	}
	
	
	// You can use the @RequestPart annotation instead of the @RequestParam annotation for this purpose. It allows you to have the content of a specific multipart passed through an HttpMessageConverter taking into consideration the 'Content-Type' header of the multipart:
	@PostMapping("/someUrl")
	public String onSubmit(/*@RequestPart("meta-data") MetaData metadata,*/
	                @RequestPart("file-data") MultipartFile file) {

	        // ...
			return "";
	}
	
	
}
