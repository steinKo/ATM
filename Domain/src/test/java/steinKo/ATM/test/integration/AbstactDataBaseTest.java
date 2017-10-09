package steinKo.ATM.test.integration;






	import java.io.StringReader;

	import java.sql.SQLException;

	import javax.sql.DataSource;

	import org.dbunit.DatabaseUnitException;
	import org.dbunit.database.DatabaseConfig;
	import org.dbunit.database.DatabaseDataSourceConnection;
	import org.dbunit.database.IDatabaseConnection;
	import org.dbunit.dataset.DataSetException;
	import org.dbunit.dataset.IDataSet;
	import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
	import org.dbunit.ext.h2.H2DataTypeFactory;
	import org.dbunit.operation.CompositeOperation;
	import org.dbunit.operation.DatabaseOperation;
	

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;




	public abstract class AbstactDataBaseTest {

	
		private final static Logger logger = LoggerFactory.getLogger(AbstractTest.class);
	    protected static  ApplicationContext applicationContext;

		 private static DataSource   dataSource ;

	
		 public static void init(String xmlDataSet, Class<?> applicationContextClass) 
		 {   applicationContext = new AnnotationConfigApplicationContext(applicationContextClass);
		    logger.info(applicationContext.toString());
			IDatabaseConnection con = null;
			IDataSet dataSet = null;
			dataSource = (DataSource) applicationContext.getBean("dataSource");
			logger.info(applicationContext.toString());
			try {
				 
				 con =  new DatabaseDataSourceConnection( dataSource);
				
				 logger.info(con.toString());
			} 
			
			catch (SQLException Se) {
				logger.info(Se.getMessage());
				Se.printStackTrace();
			}
		
			DatabaseConfig dbConfig = con.getConfig();
		    // added this line to get rid of the warning
		    dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
			
		    
			dataSet = insert(xmlDataSet);
			
			DatabaseOperation[] operations = new DatabaseOperation[2];
			operations[0] = DatabaseOperation.DELETE_ALL;
			operations[1] = DatabaseOperation.INSERT;
			
	       CompositeOperation dbo =  new CompositeOperation(operations); // Import your data
	       try {
				dbo.execute(con,dataSet);
			} catch (DatabaseUnitException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		        
		 }

		private static IDataSet insert(String xmlDataSet) {
			IDataSet dataSet;
			dataSet = null;
			FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
			builder.setColumnSensing(true);
			try {
				
				 dataSet= builder.build(new StringReader(xmlDataSet));
			
			} catch (DataSetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataSet;
		}
	 
		
		
		

	}

