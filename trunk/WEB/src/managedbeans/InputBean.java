package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import model.Customer;
import model.User;

import com.cpeeterprise.BeanCustomerRemote;
import com.cpeeterprise.BeanUserRemote;

@ManagedBean(name="input")
@SessionScoped
public class InputBean {
	
	@EJB
	public BeanCustomerRemote customerRemote;
	
	@EJB
	public BeanUserRemote userRemote;
	
	private List<SelectItem> customersItems = new ArrayList<SelectItem>();
	
	// Liste des users ayant un profil chef de projet
	private List<SelectItem> cdpItems = new ArrayList<SelectItem>();
	
	public List<SelectItem> getCustomersItems() {
		if(this.customersItems.isEmpty()){
			List<Customer> customers = customerRemote.findCustomers();
			for(Customer c:customers){
				customersItems.add(new SelectItem(c.getCusId(), c.getCusName()));
			}
		}
		return customersItems;
	}
	
	public List<SelectItem> getCdpItems() {
		if(this.cdpItems.isEmpty()){
			List<User> cdps = userRemote.findCdps();
			for(User u:cdps){
				cdpItems.add(new SelectItem(u.getUsrId(), u.getUsrFirstname() + " " + u.getUsrLastname()));
			}
		}
		return cdpItems;
	}
}