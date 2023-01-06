package vttp2022.paf.assessment.eshop.respositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
	// TODO: Task 3

	public boolean insertOrder(String name, String address, String email) { 
		int inserted = template.update(SQL_INSERT_ORDER, customer.getName(), customer.getAddress(), customer.getEmail());

		return inserted > 0;


    }
}
