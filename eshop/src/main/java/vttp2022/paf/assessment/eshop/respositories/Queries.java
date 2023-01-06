package vttp2022.paf.assessment.eshop.respositories;

public class Queries {

    public static final String SQL_CHECK_IF_CUST_EXISTS = "SELECT EXISTS (SELECT * FROM customers WHERE name = ?)"; 


}
