package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
	@Autowired
	private AccountRepository accountrepository;

	@RequestMapping("/home")
	public String home() {

		return "home.jsp";
	}

	@RequestMapping("/addAccountHolder")
	public String addAccountHolder() {
		return "adduser.jsp";

	}

	@RequestMapping("/created")
	@ResponseBody
	public ModelAndView created(Account account) {
		accountrepository.save(account);
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("obj1", account);
		modelandview.addObject("name", account.getHoldername());
		modelandview.setViewName("created.jsp");

		return modelandview;
	}

	@RequestMapping("/checkBalance")
	public ModelAndView checkBalance(ModelAndView m) {
		Account ac = new Account();
		m.addObject("obj", ac);

		m.setViewName("checkbalance.jsp");
		return m;

	}

	public AccountRepository getAccountrepository() {
		return accountrepository;
	}

	public void setAccountrepository(AccountRepository accountrepository) {
		this.accountrepository = accountrepository;
	}

	@RequestMapping("/displaybalance")
	public ModelAndView displaying(int accountId) {
		ModelAndView modelandview = new ModelAndView();
		Optional<Account> account = accountrepository.findById(accountId);
		System.out.println(account);
		Account act = account.get();
		System.out.println(act);
		modelandview.addObject("obj1", act);
		modelandview.addObject("holdername", act.getHoldername());
		modelandview.setViewName("displaybalance.jsp");

		return modelandview;

	}

	@RequestMapping("/transferAmount")
	public ModelAndView transferamount(ModelAndView m) {
		Account obj = new Account();
		m.addObject("obj", obj);
		m.setViewName("transferamount.jsp");
		return m;

	}

	@RequestMapping("/transfered")
	public String transfered(int debitid, int creditid, int amount) {
		
		Account account1 = accountrepository.getReferenceById(creditid);
		Account account2 = accountrepository.getReferenceById(debitid);
		int debitAccoutBalance = account2.getMoney();
		int creditAccoutnBalance = account1.getMoney();
		System.out.println(debitAccoutBalance - amount);
		System.out.println(creditAccoutnBalance + amount);
		account2.setMoney(debitAccoutBalance - amount);
		account1.setMoney(creditAccoutnBalance + amount);
		accountrepository.save(account2);
		accountrepository.save(account1);

		return "transfered.jsp";
	}

}
