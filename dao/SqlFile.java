package dao;

public class SqlFile {

	//Displays transactions made by customers living in a certain zip for a given month and year
	public static final String query1 = "select *" + "from cdw_sapp_creditcard cr "
			+ "JOIN cdw_sapp_customer cb ON cr.CREDIT_CARD_NO = cb.CREDIT_CARD_NO "
			+ "WHERE (cb.CUST_ZIP = ? AND cr.MONTH = ?  AND cr.YEAR = ?) " + "order by DAY desc";
	
	//Displays the number and total values of transactions for a given type 
	public static final String query2 = "select  TRANSACTION_TYPE 'Transaction Type', count(TRANSACTION_TYPE) '# of Transactions', \r\n"
			+ " sum(TRANSACTION_VALUE) 'Total Transaction Amount' " + "from cdw_sapp_creditcard cr "
			+ "WHERE cr.TRANSACTION_TYPE = ?";

	//Displays the number and total values of transactions for branches in a given state
	public static final String query3 = "SELECT count(*) '# of Transaction', sum(TRANSACTION_VALUE)"
			+ " 'Transaction Amount' " + "FROM CDW_SAPP_CREDITCARD as card " + "JOIN CDW_SAPP_BRANCH as branch "
			+ "ON card.BRANCH_CODE= branch.BRANCH_CODE " + "WHERE branch.BRANCH_STATE = ?"
			+ "GROUP BY branch.BRANCH_NAME";

	//Selects all of the details of a customer  
	public static final String query4 = "SELECT `FIRST_NAME`, `MIDDLE_NAME`, `LAST_NAME`, `SSN`, " 
			+ "`CREDIT_CARD_NO`, `APT_NO`, `STREET_NAME`, `CUST_CITY`, `CUST_STATE`, `CUST_ZIP`,"
			+ "`CUST_COUNTRY`, `CUST_PHONE`, `CUST_EMAIL`"
			+ "FROM CDW_SAPP_CUSTOMER " + "WHERE `SSN` = ?";
	
	//Changes customer first, middle, and last name 
	public static final String query5a = " update cdw_sapp_customer "
			+ " SET FIRST_NAME = ?, MIDDLE_NAME = ?, LAST_NAME = ? "
			+ "WHERE SSN = ?";
	
	//Changes address for customer 
	public static final String query5b = " update cdw_sapp_customer "
			+ "	SET APT_NO = ?, STREET_NAME = ?, CUST_CITY = ?, CUST_STATE = ?, CUST_COUNTRY = ?,"
			+ " CUST_ZIP = ? " + "WHERE SSN = ?";
	
	//Changes phone number of customer 
	public static final String query5c = " update cdw_sapp_customer "
			+ "SET CUST_PHONE = ? " + "WHERE SSN = ?";
	
	//Changes email of customer 
	public static final String query5d = " update cdw_sapp_customer "
			+ " SET CUST_EMAIL = ? " + "WHERE SSN = ?";

	//Gives bill for a given month and year
	public static final String query6 = "SELECT SUM(TRANSACTION_VALUE) as BILL " + "FROM CDW_SAPP_CREDITCARD "
			+ "WHERE CREDIT_CARD_NO = ? AND " + "MONTH = ? AND " + "YEAR = ? ";

	//Gives range of transactions based on given dates 
	public static final String query7 = "SELECT * FROM CDW_SAPP_CREDITCARD WHERE CUST_SSN = ? AND "
			+ "DATE_ADD(DATE_ADD(MAKEDATE(YEAR, 1), INTERVAL (MONTH)-1 MONTH), INTERVAL (DAY)-1 DAY) BETWEEN "
			+ "DATE_ADD(DATE_ADD(MAKEDATE( ? , 1), INTERVAL ( ? )-1 MONTH), INTERVAL ( ? )-1 DAY) AND "
			+ "DATE_ADD(DATE_ADD(MAKEDATE( ? , 1), INTERVAL  ( ? )-1 MONTH), INTERVAL ( ? )-1 DAY) "
			+ "ORDER BY YEAR DESC, MONTH DESC, DAY DESC";

}
