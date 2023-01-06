package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;
import static vttp2022.paf.assessment.eshop.respositories.Queries.*;


@Repository
public class CustomerRepository {

	@Autowired 
	private JdbcTemplate template;

	// SELECT EXISTS(SELECT * FROM customers WHERE name="harry")

	public Optional<Customer> findCustomerByName(String name) {

		final SqlRowSet rs = template.queryForRowSet(SQL_CHECK_IF_CUST_EXISTS, name);

		final List<Customer> customer = new LinkedList<>();
		while (rs.next()) {
            customer.add(customer.create(rs));
        }
        
        if (customer.size() > 0) {
            return Optional.of(customer.get(0));
        } else {
            return Optional.empty();
        }


		




         


	}

	// 	
	// 	while (rs.next())	
	// 		customer.add(order.create(rs));
	// 	return customer;




	// 	Customer customer = getCustByName.get(name);
	// 	Optional<Customer> opt = Optional.ofNullable(customer);
	// 	return opt;  


	// 	while (rs.next())
	// 	orders.add(order.create(rs));

	// 	return orders;


        
    //     if (rs.next() == true) {
    //         getCustByName = Customer.create(rs);
    //     } else {
    //         return null;
    //     }


	// 	public Optional<List<Task>> getUserTasksFromRepo(String userId) {
	// 		SqlRowSet rs = template.queryForRowSet(SQL_SELECT_TASKS_BY_USERID, userId);
	
	// 		final List<Task> taskList = new LinkedList<>();
	// 		while (rs.next()) {
	// 			taskList.add(Task.create(rs));
	// 		}
	
	// 		return Optional.of(taskList);


		//return getCustByName;
		
	}

