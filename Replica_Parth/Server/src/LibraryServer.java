
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.CosNaming.*;
import DRMSServices.* ;

import java.util.Properties;

/**
 * @author Parth Patel
 * Main class - this class provides the main method that gets the entire application started
 *It creates few specific servers and specific books on those servers
 *Java Corba is used as a middleware system
 * */
public class LibraryServer {
	
	// args consists of the location of the NamingService of the CORBA middleware
	// The NamingService can be on a user defined port, in which case the args can be used to obtain the port
	public static void main ( String[] args ) {
		// Get the system properties
		Properties orbProp = System.getProperties() ;
		
		// Initialize ORB
		ORB orb = ORB.init ( args, orbProp ) ;
		
		// The main portable object adapter
		// As we are creating only three servers the Root POA is sufficient for our purpose
		POA rootPOA = null ;
		org.omg.CORBA.Object obj = null ; // generic CORBA object
		NamingContext n = null ;	
		try {
			// Get the reference to RootPOA and NameService
			obj = orb.resolve_initial_references( "RootPOA" ) ;
			rootPOA = POAHelper.narrow(obj) ;
			obj = orb.resolve_initial_references( "NameService" ) ;
			n = NamingContextHelper.narrow(obj) ;	
		} catch ( org.omg.CORBA.ORBPackage.InvalidName e ) {
			System.out.println (e.getMessage() ) ;
		}		
		
		// Create three specific libraries
		Library libraries[] = new Library[3] ;
		
		libraries[0] = new Library ( "Concordia University", 6000 ) ;
		libraries[1] = new Library ( "McGill University", 6001 ) ;
		libraries[2] = new Library ( "Vanier College", 6004 ) ;	
		
		
		NameComponent[] name = new NameComponent[1] ;
		name[0] = new NameComponent() ;
		LibraryInterface[] libInterface = new LibraryInterface[3] ;
		
		try {
			
		
			for ( int i = 0; i != libraries.length; i++ ) {
				
				// Activate the library object and associate it with rootPOA
				byte[] id = rootPOA.activate_object(libraries[i]) ;
				
				// Get a reference to the Library object in the form of CORBA reference
				org.omg.CORBA.Object tempOBJ = rootPOA.id_to_reference(id) ;
				libInterface[i] = LibraryInterfaceHelper.narrow(tempOBJ) ;
			
				// bind the CORBA reference of library object to NameService
				name[0].id = libraries[i].getName() ;
				name[0].kind = "library" ;
				n.rebind(name, libInterface[i]);
					
			}	
		} catch ( org.omg.CORBA.UserException e) {
			System.out.println ( e.getMessage() ) ;
		} 
		
		System.out.println("The following three Libraries are currently part of the DRMS");
		System.out.println("1. Concordia University");
		System.out.println("2. McGill University");
		System.out.println("3. Vanier College");
		
		try {
			// Activate POA manager
			rootPOA.the_POAManager().activate();
		} catch (AdapterInactive e) {
			System.out.println ( e.getMessage() ) ;
		}
		// run the underlying CORBA ORB. It is now ready to receive requests from clients
		orb.run();
	}
}
